package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.Control;
import com.naosim.shootinggame.famicon.ControllerManager;
import com.naosim.shootinggame.famicon.Display;
import com.naosim.shootinggame.game.Status.Type;

public class Player extends SoulBase {

	private ControllerManager controllerManager;
	private int count = 0;

	public Player(ControllerManager controllerManager) {
		super();
		this.controllerManager = controllerManager;
	}

	@Override
	public void enterFrame() {
		if (controllerManager.isOn(Control.LEFT)) {
			status.x -= 6;
		} else if (controllerManager.isOn(Control.RIGHT)) {
			status.x += 6;
		}

		// 弾を撃つ
		count = (count + 1) % 4;
		if (count == 0) {
			Shot s = new Shot();
			s.getStatus().x = status.x;
			s.getStatus().y = status.y;
			soulAdder.add(s);
		}

	}

	@Override
	public void setupStatus(Status status) {
		status.x = Display.WIDTH / 2;
		status.y = Display.HEIGHT - 24;
		status.r = 6;
		status.type = Type.PLAYER;
		status.hp = 1;

	}

	@Override
	public void hit(Soul soul) {
		if (soul.getStatus().type == Type.ENEMY) {
			super.hit(soul);
		}
	}

}
