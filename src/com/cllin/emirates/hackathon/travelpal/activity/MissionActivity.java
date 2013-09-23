package com.cllin.emirates.hackathon.travelpal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MissionActivity extends Activity implements OnItemClickListener{
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	
	private static final int MISSION_ID_MOUNTAIN_VIEW = 1;
	private static final int MISSION_ID_PALO_ALTO = 2;
	private static final int MISSION_ID_SUNNYVALE = 3;

	private int mMissionId = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_mission);
		ListView listview = (ListView)findViewById(R.id.listview_tasks);
		ArrayAdapter<CharSequence> adapter;
		
		Bundle bundle = this.getIntent().getExtras();
		mMissionId = bundle.getInt(KEY_MISSION_ID);
		
		switch(mMissionId){
		case MISSION_ID_MOUNTAIN_VIEW:
			adapter = ArrayAdapter.createFromResource(this, R.array.task_list_mountain_view, android.R.layout.simple_spinner_item);
			break;
		case MISSION_ID_PALO_ALTO:
			adapter = ArrayAdapter.createFromResource(this, R.array.task_list_palo_alto, android.R.layout.simple_spinner_item);
			break;
		case MISSION_ID_SUNNYVALE:
			adapter = ArrayAdapter.createFromResource(this, R.array.task_list_sunnyavle, android.R.layout.simple_spinner_item);
			break;
			default:
				adapter = ArrayAdapter.createFromResource(this, R.array.task_list_mountain_view, android.R.layout.simple_spinner_item);
				break;
		}
		
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(this);
	}
	
	private void switchActivity(int idx){
		Intent intent = new Intent();
		intent.setClass(MissionActivity.this, TaskActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt(KEY_MISSION_ID, mMissionId);
        bundle.putInt(KEY_TASK_ID, idx);
        intent.putExtras(bundle);
        
        startActivity(intent);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		switchActivity(position);
	}

}
