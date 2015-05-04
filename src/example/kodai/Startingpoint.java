package example.kodai;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Startingpoint extends ListActivity {
	
	String items[] = {"General", "Map", "Resorts" , "Horse", "Quad"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Startingpoint.this, android.R.layout.simple_list_item_1, items));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String abc= items[position];
		try{
		Class inten = Class.forName("example.kodai."+ abc);
		Intent all = new Intent(Startingpoint.this,inten);
		startActivity(all);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
