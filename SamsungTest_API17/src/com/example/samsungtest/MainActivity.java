package com.example.samsungtest;


import org.openni.OpenNI;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//method called, when app is started
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startBluetooth();
		// initializeOpenNI();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void startOpenNI(View view)
	{
		// Starts a new Activity
		Intent intent = new Intent(this, OpenNIActivity.class);
		startActivity(intent);
	}
	
	public void initializeOpenNI()
	{
		OpenNI.initialize();
	}
	
	public void startBluetooth()
	{
		//Method to enable Bluetooth on the device
		BluetoothAdapter samsungAdapter = BluetoothAdapter.getDefaultAdapter();
		if(samsungAdapter == null)
		{
			//Device does not support Bluetooth
		}
		else
		{
			if(!samsungAdapter.isEnabled())
			{
				int REQUEST_ENABLE_BT = 1;
				Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
			}
		}
	}
}