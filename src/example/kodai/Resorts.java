package example.kodai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Resorts extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resort);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.optmenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {  
        case R.id.item1:  
          Toast.makeText(getApplicationContext(),"High Range Selected",Toast.LENGTH_LONG).show();  
        return true;     

        case R.id.item2:  
            Intent ai = new Intent(Resorts.this, Midresort.class);  
            startActivity(ai);
          return true;     
          
        case R.id.item3:  
        	Intent aii = new Intent(Resorts.this, Budget.class);  
            startActivity(aii);
          return true;     

          default:  

		return super.onOptionsItemSelected(item);
		
	}
}
}
