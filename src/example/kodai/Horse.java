package example.kodai;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Horse extends Activity {

	EditText dur;
	Button btnSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.horse);

		dur = (EditText) findViewById(R.id.hors);
		dur.setInputType(InputType.TYPE_CLASS_NUMBER);

		final Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final PopupMenu popup = new PopupMenu(Horse.this, b1);
				popup.getMenuInflater()
						.inflate(R.menu.popmenu, popup.getMenu());
				
				popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(android.view.MenuItem item) {
						// TODO Auto-generated method stub
						if (item.getItemId() == R.id.item1) {
							 Resources res = getResources(); //resource handle
								Drawable drawable = res.getDrawable(R.drawable.white); //new Image that was added to the res folder
								LinearLayout linearLayout =   (LinearLayout)findViewById(R.id.r1); 
								linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white));
						} else if(item.getItemId() == R.id.item2){
							Resources res = getResources(); //resource handle
							Drawable drawable = res.getDrawable(R.drawable.brown); //new Image that was added to the res folder
							LinearLayout linearLayout =   (LinearLayout)findViewById(R.id.r1); 
							linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.brown));
						} else if (item.getItemId() == R.id.item3){
							Resources res = getResources(); //resource handle
							Drawable drawable = res.getDrawable(R.drawable.black); //new Image that was added to the res folder
							LinearLayout linearLayout =   (LinearLayout)findViewById(R.id.r1); 
							linearLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.black));
						}
	                    	
						else {
							Toast.makeText(Horse.this,
									"You Chose : " + item.getTitle(),
									Toast.LENGTH_SHORT).show();
					    }
						return true;
					}
				});
				popup.show();
			}
		});

		btnSubmit = (Button) findViewById(R.id.button2);
		btnSubmit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent tent = new Intent(Horse.this, Inten.class);

				tent.putExtra("Duration", dur.getText().toString());
				startActivity(tent);
			}
		});

	}
}
