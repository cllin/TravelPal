package com.cllin.emirates.hackathon.travelpal.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskActivity extends Activity implements OnClickListener {
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	private static final String KEY_IMAGE_ID = "image_id";
	
	private static final int MISSION_ID_SANFRANCISCO = 0;
	private static final int MISSION_ID_PALO_ALTO = 1;
	private static final int MISSION_ID_SUNNYVALE = 2;
	
	private int mTaskId = -1;
	private int mMissionId = -1;
	private int mImageId = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_task);
		
		getBundle();
		setView();
	}
	
	private void getBundle(){
		Bundle bundle = this.getIntent().getExtras();
		mMissionId = bundle.getInt(KEY_MISSION_ID);
		mTaskId = bundle.getInt(KEY_TASK_ID);
		mImageId = bundle.getInt(KEY_IMAGE_ID);
	}
	
	private void setView(){
		
//		TEXTVIEW
		TextView textview = (TextView)findViewById(R.id.textview_task);
		
		String[] tasks = null;
		switch(mMissionId){
		case MISSION_ID_SANFRANCISCO:
			tasks = getResources().getStringArray(R.array.task_list_sanfrancisco);
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
		Button syncBtn = (Button)findViewById(R.id.button_task_sync);
		
		cameraBtn.setOnClickListener(TaskActivity.this);
		locationBtn.setOnClickListener(TaskActivity.this);
		syncBtn.setOnClickListener(TaskActivity.this);
		
//		TITLE
		LinearLayout title = (LinearLayout)findViewById(R.id.layout_task_title);
		title.setBackgroundResource(mImageId);
		title.setAlpha(63);
	}
	
	private void showToast(){
		final ProgressDialog progressDialog = ProgressDialog.show(this, "", "Please wait...");
			new Thread() {
				public void run() {
					try{
						synchronized(this){
		                    wait(5000);
		                }
					} catch (Exception e) {
						e.printStackTrace();
					}
					progressDialog.dismiss();
				}
			}.start();
		
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		
		int id = v.getId();
		if (id == R.id.button_task_camera) {
			intent.setClass(TaskActivity.this, CameraActivity.class);
		} else if (id == R.id.button_task_location) {
			intent.setClass(TaskActivity.this, LocationActivity.class);
		} else if (id == R.id.button_task_sync) {
			showToast();
			return;
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
