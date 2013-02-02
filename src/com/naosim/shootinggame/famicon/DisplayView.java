package com.naosim.shootinggame.famicon;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DisplayView extends SurfaceView implements Runnable {
	private boolean running;
	private Thread renderThread;
	private Drawer drawer;
	private EnterFrame enterFrame;

	/** 1フーレム時間[ナノ秒] */
	long oneFrameTime = 1 * 1000 * 1000 * 1000;

	public DisplayView(Context context) {
		super(context);
	}

	public DisplayView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DisplayView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void start() {
		running = true;
		renderThread = new Thread(this);
		renderThread.start();

	}

	public void stop() {
		running = false;
		while (true) {
			try {
				renderThread.join();
				break;
			} catch (InterruptedException e) {
				// リトライ
			}
		}
	}

	@Override
	public void run() {
		while (running) {
			long startTime = System.nanoTime();
			
			if(enterFrame != null) {
				enterFrame.enterFrame();
			}
			
			Canvas canvas = getHolder().lockCanvas();
			if (drawer != null) {
				drawer.draw(canvas);
			}
			// 描画
			getHolder().unlockCanvasAndPost(canvas);
			
			// フレームレートになるようにwait
			long endTime = System.nanoTime();
			long waitTime = oneFrameTime - (endTime - startTime);
			if (waitTime > 0) {
				try {
					Thread.sleep(waitTime / 1000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setEnterFrame(EnterFrame enterFrame) {
		this.enterFrame = enterFrame;
	}
	
	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

}
