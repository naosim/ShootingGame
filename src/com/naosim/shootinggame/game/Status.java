package com.naosim.shootinggame.game;

public class Status {
	public float x;
	public float y;
	public float r;
	public int hp;
	public Type type;
	
	public static enum Type {
		PLAYER,
		ENEMY,
		SHOT,
	}
}
