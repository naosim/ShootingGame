package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.Cassette;
import com.naosim.shootinggame.famicon.ControllerManager;
import com.naosim.shootinggame.famicon.Drawer;
import com.naosim.shootinggame.famicon.EnterFrame;
import com.naosim.shootinggame.famicon.EventManager;

public class ShootingGame implements Cassette {
	private God god;
	private MediaManager madiaManager;
	private ControllerManager controllerManager;

	public ShootingGame() {
		this.madiaManager = new MediaManager();
	}

	@Override
	public void start() {
		Stage stage = new Stage(new Player(controllerManager));
		this.god = new God(stage);
		this.madiaManager.setField(god.getField());
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public Drawer getDrawer() {
		return madiaManager;
	}

	@Override
	public EnterFrame getEnterFrame() {
		return god;
	}

	@Override
	public EventManager getEventManager() {
		return null;
	}

	@Override
	public void setControllerManager(ControllerManager controllerManager) {
		this.controllerManager = controllerManager;
	}

}
