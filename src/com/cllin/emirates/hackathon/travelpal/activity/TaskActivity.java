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
import android.widget.Toast;

public class TaskActivity extends Activity implements OnClickListener {
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	private static final String KEY_IMAGE_ID = "image_id";
	
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

//	TODO
	private void setView(){
		ImageView imageView = (ImageView)findViewById(R.id.imageview_task);
		imageView.setBackgroundResource(R.drawable.brooklyn_bridge);
		
		TextView textview = (TextView)findViewById(R.id.textview_task);
		String task = "Brooklyn Bridge";
		textview.setText(task);
		
//		BUTTON
		Button cameraBtn = (Button)findViewById(R.id.button_task_camera);
		Button locationBtn = (Button)findViewById(R.id.button_task_location);
		Button syncBtn = (Button)findViewById(R.id.button_task_sync);
		Button qandaBtn = (Button)findViewById(R.id.button_task_qanda);
		
		cameraBtn.setOnClickListener(TaskActivity.this);
		locationBtn.setOnClickListener(TaskActivity.this);
		syncBtn.setOnClickListener(TaskActivity.this);
		qandaBtn.setOnClickListener(TaskActivity.this);
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
			Toast.makeText(getApplicationContext(), "Sorry, the task is not ready yet!", Toast.LENGTH_SHORT).show();
//			intent.setClass(TaskActivity.this, CameraActivity.class);
		} else if (id == R.id.button_task_location) {
			Toast.makeText(getApplicationContext(), "Sorry, the task is not ready yet!", Toast.LENGTH_SHORT).show();
//			intent.setClass(TaskActivity.this, LocationActivity.class);
		} else if (id == R.id.button_task_sync) {
			showToast();
			return;
		} else if(id == R.id.button_task_qanda){
			intent.setClass(TaskActivity.this, QAndAActivity.class);
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
