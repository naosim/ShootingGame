package com.naosim.shootinggame.game;

import android.util.Log;

public class Enemy implements Soul {
	
	private Status status;

	public Enemy() {
		status = new Status();
		status.x = 20;
		status.y = 0;
		status.hp = 1;
		status.r = 4;
	}

	@Override
	public void enterFrame() {
		status.y += 2;
		Log.e("enemy", "y : " + status.y);
	}

	@Override
	public boolean isDead() {
		return status.hp == 0;
	}

	@Override
	public boolean hitTest(Soul soul) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Status getStatus() {
		return status;
	}

}
