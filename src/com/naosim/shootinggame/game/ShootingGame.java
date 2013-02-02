package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.Cassette;
import com.naosim.shootinggame.famicon.Drawer;
import com.naosim.shootinggame.famicon.EnterFrame;
import com.naosim.shootinggame.famicon.EventManager;

public class ShootingGame implements Cassette {
	private Stage stage = new Stage();
	private God god;
	private MediaManager madiaManager;

	public ShootingGame() {
		this.god = new God(stage);
		this.madiaManager = new MediaManager(god.getField());
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

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

}
