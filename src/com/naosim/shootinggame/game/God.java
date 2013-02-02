package com.naosim.shootinggame.game;

import java.util.ArrayList;
import java.util.List;

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
	}
	
	public List<Soul> getField() {
		return field;
	}

	@Override
	public void add(Soul soul) {
		field.add(soul);
	}

}
