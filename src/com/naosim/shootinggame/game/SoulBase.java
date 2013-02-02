package com.naosim.shootinggame.game;

public abstract class SoulBase implements Soul {
	protected Status status;
	protected SoulAdder soulAdder;
	public SoulBase() {
		status = new Status();
		setupStatus(status);
	}
	
	public abstract void setupStatus(Status status);

	@Override
	public boolean isDead() {
		return status.hp <= 0;
	}

	@Override
	public void hit(Soul soul) {
		status.hp--;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public void setSoupAdder(SoulAdder soulAdder) {
		this.soulAdder = soulAdder;
	}
}
