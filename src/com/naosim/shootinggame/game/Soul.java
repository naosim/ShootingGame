package com.naosim.shootinggame.game;

import com.naosim.shootinggame.famicon.EnterFrame;

public interface Soul extends EnterFrame {
	public boolean isDead();
	public void hit(Soul soul);
	public Status getStatus();
	public void setSoupAdder(SoulAdder soulAdder);
}
