package com.naosim.shootinggame.famicon;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceView;

public class Display implements Runnable {
	private SurfaceView surfaceView;
	private boolean running;
	private Thread renderThread;
	private Drawer drawer;
	private EnterFrame enterFrame;
	
	public static final int WIDTH = 320;
	public static final int HEIGHT = 320;

	/** 1フーレム時間[ナノ秒] */
	long oneFrameTime = 1 * 1000 * 1000 * 1000;

	public Display(SurfaceView surfaceView) {
		this.surfaceView = surfaceView;
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
			Canvas canvas = surfaceView.getHolder().lockCanvas();
			
			if (canvas != null) {
				float width = canvas.getWidth();
				float sx = width / WIDTH;
				canvas.scale(sx, sx);
				canvas.clipRect(new Rect(0, 0, WIDTH, HEIGHT));
				if (enterFrame != null) {
					enterFrame.enterFrame();
				}

				if (drawer != null) {
					drawer.draw(canvas);
				}
				// 描画
//				canvas.scale(width / 256.0f, width / 256.0f);
				surfaceView.getHolder().unlockCanvasAndPost(canvas);
			}
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

	public void setFramerate(long nanosec) {
		oneFrameTime = nanosec;
	}

}
