package com.naosim.shootinggame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.SurfaceView;

import com.naosim.shootinggame.famicon.Cassette;
import com.naosim.shootinggame.famicon.Display;
import com.naosim.shootinggame.famicon.Famicon;
import com.naosim.shootinggame.game.ShootingGame;

public class MainActivity extends Activity {

	private Famicon famicon;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Cassette cassette = new ShootingGame();

		Display display = new Display((SurfaceView) findViewById(R.id.gameMain));
		famicon = new Famicon(display);
		famicon.setCassette(cassette);
	}

	@Override
	protected void onResume() {
		super.onResume();
		famicon.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		famicon.stop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
