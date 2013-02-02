package com.naosim.shootinggame.game;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.naosim.shootinggame.famicon.Display;
import com.naosim.shootinggame.famicon.EnterFrame;

public class God implements EnterFrame, SoulAdder {
	
	
	private Stage stage;
	List<Soul> field = new ArrayList<Soul>();

	public God(Stage stage) {
		this.stage = stage;
		stage.setSoulAdder(this);
	}

	@Override
	public void enterFrame() {
		stage.enterFrame();
		for(Soul soul : field) {
			soul.enterFrame();
		}
		
		for(int i = 0; i < field.size();) {
			Soul soul = field.get(i);
			if(isOutOfDisplay(soul)) {
				field.remove(soul);
			} else {
				i++;
			}
		}
		
		Log.e("god", "count : " + field.size());
	}
	
	private static boolean isOutOfDisplay(Soul soul) {
		
		Status status = soul.getStatus();
		float x = status.x;
		float y = status.y;
		float r = status.r;
		if(x + r < - Display.WIDTH / 2 || x - r > Display.WIDTH * 3 / 2 || y + r < - Display.HEIGHT / 2 || y - r > Display.HEIGHT * 3 / 2) {
			return true;
		}
		
		
		return false;
	}
	
	public List<Soul> getField() {
		return field;
	}

	@Override
	public void add(Soul soul) {
		field.add(soul);
	}

}
