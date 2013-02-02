package com.naosim.shootinggame.game;

import java.util.Random;

import com.naosim.shootinggame.famicon.Display;
import com.naosim.shootinggame.famicon.EnterFrame;

public class Stage implements EnterFrame {

	private SoulAdder soulAdder;
	private Random random = new Random();
	private Soul player;

	int count = 0;

	public Stage(Soul player) {
		this.player = player;
	}

	public void setSoulAdder(SoulAdder soulAdder) {
		this.soulAdder = soulAdder;
		soulAdder.add(player);
		player.setSoupAdder(soulAdder);
	}

	@Override
	public void enterFrame() {

		if (count == 0) {
			Enemy enemy = new Enemy();
			enemy.setSoupAdder(soulAdder);
			enemy.getStatus().x = (float) random.nextInt(Display.WIDTH);
			this.soulAdder.add(enemy);
		}
		count = (count + 1) % 20;
	}

}
