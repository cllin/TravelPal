package com.cllin.emirates.hackathon.travelpal.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TaskActivity extends Activity implements OnClickListener {
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	
	private static final int MISSION_ID_MOUNTAIN_VIEW = 1;
	private static final int MISSION_ID_PALO_ALTO = 2;
	private static final int MISSION_ID_SUNNYVALE = 3;
	
//	private static final int TASK_ID_CASTRO_STREERT = 1;
//	private static final int TASK_ID_GOOGLE_PARK = 2;
//	private static final int TASK_ID_SHORELINE_AMPHITHEATRE = 3;
//	private static final int TASK_ID_STANFORD_UNIVERSITY = 4;
//	private static final int TASK_ID_DOWNTOWN_PALO_ALTO = 5;
//	private static final int TASK_ID_HP_GARAGE = 6;
//	private static final int TASK_ID_DOWNTOWN_SUNNYVALE = 7;
//	private static final int TASK_ID_YAHOO = 8;
//	private static final int TASK_ID_LOCKHEED_MARTIN = 9;
	
	private int mTaskId = -1;
	private int mMissionId = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		
		getBundle();
		setView();
	}
	
	private void getBundle(){
		Bundle bundle = this.getIntent().getExtras();
		mMissionId = bundle.getInt(KEY_MISSION_ID);
		mTaskId = bundle.getInt(KEY_TASK_ID);
	}
	
	private void setView(){
//		TEXTVIEW
		TextView textview = (TextView)findViewById(R.id.textview_task);
		
		String[] tasks = null;
		switch(mMissionId){
		case MISSION_ID_MOUNTAIN_VIEW:
			tasks = getResources().getStringArray(R.array.task_list_mountain_view);
			break;
		case MISSION_ID_PALO_ALTO:
			tasks = getResources().getStringArray(R.array.task_list_palo_alto);
			break;
		case MISSION_ID_SUNNYVALE:
			tasks = getResources().getStringArray(R.array.task_list_sunnyavle);
			break;
		}
		String task = tasks[mTaskId];
		textview.setText(task);
		
//		BUTTON
		Button cameraBtn = (Button)findViewById(R.id.button_task_camera);
		Button locationBtn = (Button)findViewById(R.id.button_task_location);
		
		cameraBtn.setOnClickListener(TaskActivity.this);
		locationBtn.setOnClickListener(TaskActivity.this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		
		int id = v.getId();
		if (id == R.id.button_task_camera) {
			intent.setClass(TaskActivity.this, CameraActivity.class);
		} else if (id == R.id.button_task_location) {
			intent.setClass(TaskActivity.this, LocationActivity.class);
		} else {
			return;
		}
		
		Bundle bundle = new Bundle();
		bundle.putInt(KEY_MISSION_ID, mMissionId);
        bundle.putInt(KEY_TASK_ID, mTaskId);
        intent.putExtras(bundle);
		
		startActivity(intent);
		
	}

}
