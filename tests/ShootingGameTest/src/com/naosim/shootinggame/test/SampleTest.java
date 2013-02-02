package com.naosim.shootinggame.test;

import android.graphics.Canvas;
import android.test.AndroidTestCase;

import com.naosim.shootinggame.famicon.Drawer;

public class SampleTest extends AndroidTestCase {
	
	public void test() {
		Drawer a = new Drawer() {

			@Override
			public void draw(Canvas canvas) {
				assertTrue(true);
			}
		};
		
		a.draw(null);
	}

}
