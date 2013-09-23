package com.cllin.emirates.hackathon.travelpal.activity;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class LocationActivity extends Activity implements LocationListener{
	private static final String MSG_TAG = "LocationActivity";
	
	private LocationManager mLocationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_location);
		
		setView();
		setLocation();
	}
	
	private void setView(){
	}
	
	private void setLocation(){
		mLocationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
		
		if(mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) == null){
			return;
		}else{
			onLocationChanged(mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
		}
	}
	
//	TODO
//	private void setMap(Location location){
//		LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
//		
//        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
//        map.addMarker(new MarkerOptions().position(loc).title("This is where you are!").snippet("N"));
//
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 16));
//	}

	@Override
	public void onLocationChanged(Location location) {
		Log.d(MSG_TAG, location.getLatitude() + "," + location.getLongitude());
//		setMap(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
