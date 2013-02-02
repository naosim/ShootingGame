package com.naosim.shootinggame.game;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

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
		for (int i = 0, count = field.size(); i < count; i++) {
			Soul soul = field.get(i);
//		for (Soul soul : field) {
			Paint paint = new Paint();
			if(soul.isDead()) {
				paint.setColor(Color.argb(255, 255, 255, 0));
			} else {
				paint.setColor(Color.argb(255, 255, 255, 255));
			}
			
			Rect rect = new Rect(
					(int) (soul.getStatus().x - soul.getStatus().r),
					(int) (soul.getStatus().y - soul.getStatus().r),
					(int) (soul.getStatus().x + soul.getStatus().r),
					(int) (soul.getStatus().y + soul.getStatus().r));
			canvas.drawRect(rect, paint);
		}
	}
}
