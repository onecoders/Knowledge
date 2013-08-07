package com.example.simpleclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SimpleClientActivity extends Activity {

	private EditText display;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		display = (EditText) findViewById(R.id.display);
		button = (Button) findViewById(R.id.button);

		new Thread() {
			public void run() {
				try {
					Socket socket = new Socket("192.168.1.100", 30000);
					BufferedReader br = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					String line = br.readLine();
					display.setText(line);
					br.close();
					socket.close();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		}.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_client, menu);
		return true;
	}

}
