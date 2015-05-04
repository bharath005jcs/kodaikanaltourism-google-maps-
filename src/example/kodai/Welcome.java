package example.kodai;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Welcome extends Activity {
	
	MediaPlayer song;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome);
		song = MediaPlayer.create(Welcome.this, R.raw.kodai_trans);
		song.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openstart = new Intent("example.kodai.STARTINGPOINT");
					startActivity(openstart);					
				}
			}
			
		};
		timer.start();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}

}
