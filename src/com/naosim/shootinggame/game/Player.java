package com.naosim.shootinggame.game;

import android.util.Log;

import com.naosim.shootinggame.famicon.Control;
import com.naosim.shootinggame.famicon.ControllerManager;
import com.naosim.shootinggame.famicon.Display;

public class Player implements Soul {
	
	private ControllerManager controllerManager;
	private Status status;

	public Player(ControllerManager controllerManager) {
		this.controllerManager = controllerManager;
		status = new Status();
		status.x = Display.WIDTH / 2;
		status.y = Display.HEIGHT - 24;
		status.r = 6;
		status.type = 1;
		status.hp = 1;
	}

	@Override
	public void enterFrame() {
		if(controllerManager.isOn(Control.LEFT) ) {
			status.x -= 6;
		} else if(controllerManager.isOn(Control.RIGHT)) {
			status.x += 6;
		}
		
	}

	@Override
	public boolean isDead() {
		return status.hp <= 0;
	}

	@Override
	public void hit(Soul soul) {
		status.hp --;
		
	}

	@Override
	public Status getStatus() {
		return status;
	}

}
