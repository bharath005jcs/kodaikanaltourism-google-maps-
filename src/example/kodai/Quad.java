package example.kodai;

import java.util.Calendar;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class Quad extends Activity implements OnClickListener  {
	
	EditText txthr, txtdate;
	private int mHour, mMinute;
	Button timepick, amount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quad);
		timepick = (Button) findViewById(R.id.btntime);
		amount = (Button) findViewById(R.id.amnt);
		
		
		txtdate = (EditText) findViewById(R.id.txtDate);
        txthr = (EditText) findViewById(R.id.txthr);
       txthr.setInputType(InputType.TYPE_CLASS_NUMBER);

       timepick.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
        if (v == timepick) {
        	 
            // Process to get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
 

            TimePickerDialog tpd = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener(){
 
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                int minute) {
                        	
                            txtdate.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            tpd.show();
        }
        
        amount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String a = txthr.getText().toString();
				a= a + 00;
				
				//Toast.makeText(Quad.this,"Pay : " + a,Toast.LENGTH_SHORT).show();
				
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);	
				Notification notification = new Notification(R.drawable.veno, "Quad Racing", System.currentTimeMillis());
				PendingIntent contentIntent = PendingIntent.getActivity(Quad.this, 0, new Intent(getApplicationContext(), Quad.class), 0);
				notification.setLatestEventInfo(Quad.this, "Amount to Pay is " + a,"Thank You", contentIntent);
				manager.notify(100, notification);
			}
		});
		
	}

}
