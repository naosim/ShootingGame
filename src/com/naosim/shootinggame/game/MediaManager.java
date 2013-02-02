package com.naosim.shootinggame.game;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.naosim.shootinggame.famicon.Drawer;

public class MediaManager implements Drawer {

	private List<Soul> field;

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
			int color = Color.BLUE;
			String s = "W";
			if(soul.getStatus().type == 1) {
				color = Color.RED;
				s = "A";
			}
			paint.setColor(color);
			paint.setTextSize(24);
			canvas.drawText(s, soul.getStatus().x - 12,
					soul.getStatus().y - 12, paint);
		}
	}

}
