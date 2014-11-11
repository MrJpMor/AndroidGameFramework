package br.jp.engine.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	
	private List<String> examples = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		examples.add(" Kickball ");
		examples.add(" Reverse ");
		examples.add(" Spaceship ");
		
		ArrayList<HashMap<String, String>> itens = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < examples.size(); i++) {
			HashMap<String, String> examplesMap = new HashMap<String, String>();
			examplesMap.put("nome", examples.get(i));
			itens.add(examplesMap);
		}

		String[] from = new String[]{"nome"};
		int[] to = new int[]{android.R.id.text1};
		int resource = android.R.layout.simple_selectable_list_item;

		SimpleAdapter adapter = new SimpleAdapter(this, itens, resource, from, to);

		setListAdapter(adapter);

	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		switch (position) {
		case 0:
			startActivity(new Intent(this, KickballExActivity.class));
			break;
		case 1:
			startActivity(new Intent(this, ReverseExActivity.class));
			break;
		case 2:
			startActivity(new Intent(this, SpaceshipExActivity.class));
			break;

		default:
			break;
		}
	}

	//	@Override
	//	public boolean onCreateOptionsMenu(Menu menu) {
	//
	//		getMenuInflater().inflate(R.menu.main, menu);
	//		return true;
	//	}
	//
	//	@Override
	//	public boolean onOptionsItemSelected(MenuItem item) {
	//
	//		int id = item.getItemId();
	//		if (id == R.id.action_settings) {
	//			return true;
	//		}
	//		return super.onOptionsItemSelected(item);
	//	}



}
