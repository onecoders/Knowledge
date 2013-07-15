package com.example.timecounter;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TimeCounter extends Activity {
	
	private Timer T;
	private TextView show;
	private Button pause;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		show = (TextView) findViewById(R.id.show);
		show.setTextColor(Color.BLACK);
		pause = (Button) findViewById(R.id.pause);
		
		T = new Timer();
		T.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						show.setText("count = " + count);
						count++;
					}
				});
			}
		}, 1000, 1000);
		
		pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				T.cancel();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.time_counter, menu);
		return true;
	}

}
