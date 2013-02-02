package com.naosim.shootinggame.famicon;

import com.naosim.shootinggame.famicon.ControllerManager.ControlButtons;

public class Famicon implements EnterFrame {
	private Display display;
	private Cassette cassette;
	private ControllerManager controllerManager;

	public Famicon(Display display, ControlButtons buttons) {
		this.display = display;
		display.setFramerate(1000 * 1000 * 1000 / 16);
		display.setEnterFrame(this);
		this.controllerManager = new ControllerManager(buttons);
	}

	public void setCassette(Cassette cassette) {
		this.cassette = cassette;
	}

	public void start() {
		cassette.start();
		display.start();
		
		cassette.setControllerManager(controllerManager);
		display.setDrawer(cassette.getDrawer());
	}

	public void stop() {
		display.stop();
	}

	@Override
	public void enterFrame() {
		if(cassette.getEnterFrame() != null) {
			cassette.getEnterFrame().enterFrame();
		}
		
		if (controllerManager != null)
			controllerManager.enterFrame();

	}

}
