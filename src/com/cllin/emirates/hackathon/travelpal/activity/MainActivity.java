package com.cllin.emirates.hackathon.travelpal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener{
//	TODO this should be in application level
	private static final String KEY_MISSION_ID = "mission_id";
	private static final int SPINNER_DEFAULT_POSITION = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_main);
		Spinner spinner = (Spinner) findViewById(R.id.spinner_select_mission);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.mission_list, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}
	
	private void switchActivity(long idx){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, MissionActivity.class);
		Bundle bundle = new Bundle();
        bundle.putInt(KEY_MISSION_ID, (int)idx);
        intent.putExtras(bundle);
        
        startActivity(intent);
	}

	@Override
	public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
		if(position != SPINNER_DEFAULT_POSITION){
			switchActivity(position);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}
}
