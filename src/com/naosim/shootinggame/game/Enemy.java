package com.naosim.shootinggame.game;

import com.naosim.shootinggame.game.Status.Type;

public class Enemy extends SoulBase {
	
	public float vx = 0;
	public float vy = 2;

	@Override
	public void enterFrame() {
		status.x += vx;
		status.y += vy;
		
	}

	@Override
	public void setupStatus(Status status) {
		status.x = 20;
		status.y = 0;
		status.hp = 1;
		status.r = 8;
		status.type = Type.ENEMY;
	}
	
	@Override
	public void hit(Soul soul) {
		if(soul.getStatus().type != Type.ENEMY) {
			super.hit(soul);
		}
	}
	
	@Override
	public boolean isDead() {
		boolean result = super.isDead();
		if(result) {
			Enemy enemy = createChild(vx - 1);
			if(enemy.status.r > 0) {
				soulAdder.add(enemy);
			}
			
			Enemy enemy2 = createChild(vx + 1);
			if(enemy2.status.r > 0) {
				soulAdder.add(enemy2);
			}
			
		}
		return result;
	}
	
	public Enemy createChild(float vx) {
		Enemy enemy = new Enemy();
		enemy.setSoupAdder(soulAdder);
		enemy.vx = vx;
		enemy.vy = vy + 1;
		enemy.status.x = status.x;
		enemy.status.y = status.y;
		enemy.status.r = status.r / 2;
		return enemy;
	}

}
