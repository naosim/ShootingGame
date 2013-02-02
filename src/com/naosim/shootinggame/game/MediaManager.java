package com.naosim.shootinggame.game;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.naosim.shootinggame.famicon.Drawer;

public class MediaManager implements Drawer {

	private List<Soul> field;
	private int count;

	public MediaManager() {
	}
	
	public void setField(List<Soul> field) {
		this.field = field;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.GRAY);
		
		for(Soul soul : field) {
			Paint paint = new Paint();
			paint.setColor(Color.BLUE);
			paint.setTextSize(24);
			canvas.drawText("w", soul.getStatus().x,
					soul.getStatus().y, paint);

			
		}
	}

}
