package com.naosim.shootinggame.game;

import com.naosim.shootinggame.game.Status.Type;

public class Enemy extends SoulBase {

	@Override
	public void enterFrame() {
		status.y += 2;
	}

	@Override
	public void setupStatus(Status status) {
		status.x = 20;
		status.y = 0;
		status.hp = 1;
		status.r = 6;
		status.type = Type.ENEMY;
		
	}
	
	@Override
	public void hit(Soul soul) {
		if(soul.getStatus().type != Type.ENEMY) {
			super.hit(soul);
		}
	}

}
