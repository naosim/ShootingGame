package com.naosim.shootinggame.famicon;


public class Famicon {
	private Display display;
	
	public Famicon(Display display) {
		this.display = display;
		display.setFramerate(1000*1000*1000 / 16);
	}

	public void setCassette(Cassette cassette) {
		display.setEnterFrame(cassette.getEnterFrame());
		display.setDrawer(cassette.getDrawer());
	}
	
	public void start() {
		display.start();
	}
	
	public void stop() {
		display.stop();
	}

}
