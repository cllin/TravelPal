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

public class QAndAActivity extends Activity implements OnClickListener{
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
		
		setContentView(R.layout.activity_qanda);
		
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
		ImageView imageView = (ImageView)findViewById(R.id.imageview_qanda);
		imageView.setBackgroundResource(R.drawable.brooklyn_bridge);
		
		TextView textview = (TextView)findViewById(R.id.textview_qanda);
		String task = "Brooklyn Bridge";
		textview.setText(task);
		
//		BUTTON
	}
	

	@Override
	public void onClick(View v) {
//		TODO
	}
}
