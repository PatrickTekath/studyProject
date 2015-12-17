package com.lpe.dscanner;

import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	
	//Method to enable bluetooth on the device and search for devices
	public void enableBluetooth(View view)
	{
		BluetoothAdapter samsungBT = BluetoothAdapter.getDefaultAdapter();
		ArrayAdapter<String> mArrayAdapter;
		
		//Check if samsungBT is empty
		if(samsungBT == null)
		{
			//device does not support bluetooth
		}
		else
		{
			//Bluetooth should be enabled without user interaction
			if(!samsungBT.isEnabled())
			{
				samsungBT.enable();
			}
			//Query for devices
			Set<BluetoothDevice> devices = samsungBT.getBondedDevices();
			
			if(devices.size() > 0)
			{
				for(BluetoothDevice device : devices)
				{
					//mArrayAdapter = new ArrayAdapter<String>(this, activity_main.xml);
					//mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
				}
			}
		}
	}
	
	
}
