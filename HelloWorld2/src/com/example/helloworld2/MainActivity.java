package com.example.helloworld2;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Button button1;
		Button btnShowWeb;
		Button buttonWifiState;
		final ToggleButton tbWifi;
		final WifiManager wifiManager =(WifiManager)getSystemService(Context.WIFI_SERVICE);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1=(Button)findViewById(R.id.button1);
		btnShowWeb=(Button)findViewById(R.id.Button01);
		tbWifi=(ToggleButton)findViewById(R.id.toggleButton1);	
		buttonWifiState=(Button)findViewById(R.id.button3);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "button popup", Toast.LENGTH_SHORT).show();
			}
		});
		
		btnShowWeb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("LCH_INFO","click btnShowWeb");
				Uri		uri = Uri.parse("http://m.naver.com");
				Intent intentWebView=new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intentWebView);
			}
		});
		
		tbWifi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tbWifi.isChecked()){
//					Toast.makeText(getApplicationContext(), "Wifi on", Toast.LENGTH_SHORT).show();
//					Log.i("LCH_INFO","wifi on");
					if(!wifiManager.isWifiEnabled()){
						wifiManager.setWifiEnabled(true);
					}
				}else{
//					Toast.makeText(getApplicationContext(), "Wifi off", Toast.LENGTH_SHORT).show();
					Log.i("LCH_INFO","wifi off");
					if(wifiManager.isWifiEnabled()){
						wifiManager.setWifiEnabled(false);
					}
				}
				
			}
		});
		buttonWifiState.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(wifiManager.isWifiEnabled()){
					Log.i("LCH_INFO","wifi on");
					Toast.makeText(getApplicationContext(), "Wifi on", Toast.LENGTH_SHORT).show();
				}else{
					Log.i("LCH_INFO","wifi off");
					Toast.makeText(getApplicationContext(), "Wifi off", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
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
			Toast.makeText(getApplicationContext(), "menu popup1", Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
