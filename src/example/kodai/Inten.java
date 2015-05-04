package example.kodai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Inten extends Activity{
	
	
	TextView tvView, tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inten);
		tvView = (TextView) findViewById(R.id.tvView);
		tv = (TextView) findViewById(R.id.textView1);
	    
	    Intent intent = getIntent();
	    
	    String dura = intent.getStringExtra("Duration");
	    
	    int converted=Integer.parseInt(dura);
	    tvView.setText("Duration is: " + dura + " minutes");
	   tv.setText("Amount is: "+converted * 5);
	
	}
}
