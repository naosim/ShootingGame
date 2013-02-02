package com.naosim.shootinggame.famicon;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.view.View;

@SuppressLint("ParserError")
public class ControllerManager implements EnterFrame {

	private ControlButtons buttons;

	HashMap<Control, Boolean> controlMap = new HashMap<Control, Boolean>();

	public ControllerManager(ControlButtons buttons) {
		this.buttons = buttons;
	}

	public boolean isOn(Control control) {
		if (control == Control.LEFT && buttons.left.isPressed()) {
			return true;
		} else if (control == Control.RIGHT && buttons.right.isPressed()) {
			return true;
		} else if (controlMap.get(control) != null) {
			return true;
		}

		return false;
	}

	@Override
	public void enterFrame() {
		controlMap = new HashMap<Control, Boolean>();
	}
	
	public static class ControlButtons {
		View left;
		View right;
	}

}
