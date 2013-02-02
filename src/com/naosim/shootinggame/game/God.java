package com.naosim.shootinggame.game;

import java.util.ArrayList;
import java.util.List;

import com.naosim.shootinggame.famicon.Display;
import com.naosim.shootinggame.famicon.EnterFrame;

public class God implements EnterFrame, SoulAdder {

	private Stage stage;
	List<Soul> field = new ArrayList<Soul>();

	public God(Stage stage) {
		this.stage = stage;
		stage.setSoulAdder(this);
	}

	@Override
	public void enterFrame() {
		killSouls();

		stage.enterFrame();
		for (Soul soul : field) {
			soul.enterFrame();
		}

		// あたり判定
		hitTest(field);
	}

	/** よしなに殺す */
	private void killSouls() {
		for (int i = 0; i < field.size();) {
			Soul soul = field.get(i);
			// 画面外 または 死んでる場合
			if (isOutOfDisplay(soul) || soul.isDead()) {
				field.remove(soul);
			} else {
				i++;
			}
		}
	}

	public void hitTest(List<Soul> field) {
		// 総当たりで、当たり判定をする
		for (int i = 0; i < field.size() - 1; i++) {
			Soul a = field.get(i);
			for (int j = i + 1; j < field.size(); j++) {
				Soul b = field.get(j);
				if (hitTest(a.getStatus(), b.getStatus())) {
					a.hit(b);
					b.hit(a);
				}
			}
		}
	}

	public static boolean hitTest(Status a, Status b) {
		if(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2) < Math.pow(a.r + b.r, 2)) {
			return true;
		}
		return false;
	}

	private static boolean isOutOfDisplay(Soul soul) {

		Status status = soul.getStatus();
		float x = status.x;
		float y = status.y;
		float r = status.r;
		if (x + r < -Display.WIDTH / 2 || x - r > Display.WIDTH * 3 / 2
				|| y + r < -Display.HEIGHT / 2
				|| y - r > Display.HEIGHT * 3 / 2) {
			return true;
		}

		return false;
	}

	public List<Soul> getField() {
		return field;
	}

	@Override
	public void add(Soul soul) {
		field.add(soul);
	}

}
