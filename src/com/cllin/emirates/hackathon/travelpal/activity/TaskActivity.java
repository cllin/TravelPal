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
import android.widget.TextView;
import android.widget.Toast;

import com.cllin.emirates.hackathon.travelpal.task.Task;

public class TaskActivity extends Activity implements OnClickListener {
	private static final String KEY_TASK = "task";
	private Task mTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_task);
		
		Intent intent = getIntent();
		mTask = (Task)intent.getSerializableExtra(KEY_TASK);
		
		setView();
	}

//	TODO
	private void setView(){
		ImageView imageView = (ImageView)findViewById(R.id.imageview_task);
		imageView.setBackgroundResource(mTask.getMyImage());
		
		TextView textview = (TextView)findViewById(R.id.textview_task);
		TextView description1 = (TextView)findViewById(R.id.textview_task_description_1);
		TextView description2 = (TextView)findViewById(R.id.textview_task_description_2);
		TextView description3 = (TextView)findViewById(R.id.textview_task_description_3);
		textview.setText(mTask.getMyName());
		description1.setText(mTask.getDescriptions()[0]);
		description2.setText(mTask.getDescriptions()[1]);
		description3.setText(mTask.getDescriptions()[2]);
		
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
			intent.setClass(TaskActivity.this, CameraActivity.class);
		} else if (id == R.id.button_task_location) {
//			TODO
			Toast.makeText(getApplicationContext(), "Sorry, the task is not ready yet!", Toast.LENGTH_SHORT).show();
			return;
//			intent.setClass(TaskActivity.this, LocationActivity.class);
		} else if (id == R.id.button_task_sync) {
			showToast();
			return;
		} else if(id == R.id.button_task_qanda){
			intent.setClass(TaskActivity.this, QAndAActivity.class);
		} else {
			return;
		}
		
		intent.putExtra(KEY_TASK, mTask);
		startActivity(intent);
	}

}
