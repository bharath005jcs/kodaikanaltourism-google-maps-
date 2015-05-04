package example.kodai;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Midresort extends Activity {

	ListView listView1;
	String resort[] = { "J.C.Residency", "Villa Retreat", "Paradise Inn",
			"Kodai International"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.midresort);

		listView1 = (ListView) findViewById(R.id.listView1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, resort);
		listView1.setAdapter(adapter);

		registerForContextMenu(listView1);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("Select The Action");
		menu.add(0, v.getId(), 0, "Status");// groupId, itemId, order, title
		menu.add(0, v.getId(), 0, "Book");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getTitle()=="Status"){  
			             Toast.makeText(getApplicationContext(),"Available",Toast.LENGTH_LONG).show();  
			            }    
		else if(item.getTitle()=="Book"){  
			                Toast.makeText(getApplicationContext(),"Room Booked",Toast.LENGTH_LONG).show();  
		           }else{
		        	   return false;
		           }
return true;

	}

}
