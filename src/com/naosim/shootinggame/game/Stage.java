package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.EnterFrame;

public class Stage implements EnterFrame {
	
	private SoulAdder soulAdder;

	public void setSoulAdder(SoulAdder soulAdder) {
		this.soulAdder = soulAdder;
		this.soulAdder.add(new Enemy());
	}

	@Override
	public void enterFrame() {
	}

}
