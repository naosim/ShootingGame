package com.naosim.shootinggame.famicon;

public interface Cassette {
	public void start();
	public void reset();
	public Drawer getDrawer();
	public EnterFrame getEnterFrame();
	public EventManager getEventManager();
	public void setControllerManager(ControllerManager controllerManager);
}
