package br.jp.engine.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import br.jp.engine.examples.Spaceship.SpaceController;
import br.jp.game.R;

public class SpaceshipExActivity extends Activity {

	private SpaceController sc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sc = new SpaceController(this);
		setContentView(sc);
	}
	@Override
	protected void onResume() {
		super.onResume();
		sc.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		sc.pause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		sc.stop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spaceship_example, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
