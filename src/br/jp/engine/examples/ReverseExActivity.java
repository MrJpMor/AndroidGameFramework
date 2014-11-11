package br.jp.engine.examples;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import br.jp.engine.examples.reverse.ReverseController;
import br.jp.game.R;

public class ReverseExActivity extends Activity {

	private ReverseController rc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		rc = new ReverseController(this);
		setContentView(rc);
		
	}
	@Override
	protected void onResume() {
		super.onResume();
		rc.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		rc.pause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		rc.stop();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reverse_example, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return false;
		}
		return super.onOptionsItemSelected(item);
	}
}
