package com.naosim.shootinggame.famicon;

import java.util.HashMap;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

@SuppressLint("ParserError")
public class ControllerManager implements EnterFrame, OnTouchListener {

	private ControlButtons buttons;

	HashMap<Control, Boolean> controlMap = new HashMap<Control, Boolean>();

	public ControllerManager(ControlButtons buttons) {
		this.buttons = buttons;
		buttons.left.setOnTouchListener(this);
		buttons.right.setOnTouchListener(this);
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
		public View left;
		public View right;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(v == buttons.left) {
			controlMap.put(Control.LEFT, Boolean.TRUE);
		} else {
			controlMap.put(Control.RIGHT, Boolean.TRUE);
		}
		return false;
	}

}
