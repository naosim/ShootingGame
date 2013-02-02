package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.ControllerManager;

public class Player implements Soul {
	
	private ControllerManager controllerManager;
	private Status status;

	public Player(ControllerManager controllerManager) {
		this.controllerManager = controllerManager;
		status = new Status();
		status.x = 100f;
		status.y = 100f;
		status.type = 1;
	}

	@Override
	public void enterFrame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void hit(Soul soul) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getStatus() {
		return status;
	}

}
