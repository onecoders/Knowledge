package com.example.animationtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView imageview;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Animation zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);

		imageview = (ImageView) findViewById(R.id.imageview);
		button = (Button) findViewById(R.id.button);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				imageview.startAnimation(zoom);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
