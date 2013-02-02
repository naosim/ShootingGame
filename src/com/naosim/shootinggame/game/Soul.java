package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.EnterFrame;

public interface Soul extends EnterFrame {
	public boolean isDead();
	public boolean hitTest(Soul soul);
	public void hit();
	public Status getStatus();
}
