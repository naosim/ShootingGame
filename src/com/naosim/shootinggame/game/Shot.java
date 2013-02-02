package com.naosim.shootinggame.game;

import com.naosim.shootinggame.game.Status.Type;

public class Shot extends SoulBase {

	@Override
	public void enterFrame() {
		status.y -= 12;

	}

	@Override
	public void setupStatus(Status status) {
		status.hp = 1;
		status.r = 2;
		status.type = Type.SHOT;
	}

	@Override
	public void hit(Soul soul) {
		if (soul.getStatus().type != Type.PLAYER) {
			super.hit(soul);
		}
	}

}
