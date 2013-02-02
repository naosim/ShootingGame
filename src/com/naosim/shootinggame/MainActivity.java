package com.naosim.shootinggame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceView;

import com.naosim.shootinggame.famicon.Cassette;
import com.naosim.shootinggame.famicon.Display;
import com.naosim.shootinggame.famicon.Drawer;
import com.naosim.shootinggame.famicon.EnterFrame;

@SuppressLint("ParserError")
public class MainActivity extends Activity implements Drawer, EnterFrame{

    private Display display;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                
        display = new Display((SurfaceView)findViewById(R.id.gameMain));
        display.setEnterFrame(this);
        display.setDrawer(this);
        new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				display.start();
			}
        	
        }, 1000);
    }
	
	@Override
	protected void onPause() {
		super.onPause();
		display.stop();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void draw(Canvas canvas) {
		Paint paint = new Paint();
		canvas.drawColor(Color.WHITE);
		paint.setColor(Color.BLUE);
		paint.setAntiAlias(true);
		paint.setTextSize(24);

		canvas.drawText("Hello, SurfaceView! " + count, 0, paint.getTextSize(),
				paint);
		Log.e("###", "loop");
		
	}

	int count = 0;
	
	@Override
	public void enterFrame() {
		count++;
		
	}

    
}
