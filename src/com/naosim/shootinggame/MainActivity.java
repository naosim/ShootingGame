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

import com.naosim.shootinggame.famicon.Cassette;
import com.naosim.shootinggame.famicon.DisplayView;
import com.naosim.shootinggame.famicon.Drawer;

@SuppressLint("ParserError")
public class MainActivity extends Activity implements Drawer{

    private DisplayView surfaceView;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        surfaceView = (DisplayView)findViewById(R.id.gameMain);
        surfaceView.setDrawer(this);
        new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				surfaceView.start();
			}
        	
        }, 1000);
    }
	
	@Override
	protected void onPause() {
		super.onPause();
		surfaceView.stop();
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

		canvas.drawText("Hello, SurfaceView!", 0, paint.getTextSize(),
				paint);
		Log.e("###", "loop");
		
	}

    
}
