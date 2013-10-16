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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.cllin.emirates.hackathon.travelpal.task.Task;

public class QAndAActivity extends Activity implements OnClickListener{
	private static final String KEY_TASK = "task";
	private Task mTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_qanda);
		
		Intent intent = getIntent();
		mTask = (Task)intent.getSerializableExtra(KEY_TASK);
		
		setView();
	}

//	TODO
	private void setView(){
		ImageView imageView = (ImageView)findViewById(R.id.imageview_qanda);
		imageView.setBackgroundResource(mTask.getMyImage());
		
		TextView textview = (TextView)findViewById(R.id.textview_qanda);
		TextView question = (TextView)findViewById(R.id.textview_qanda_question);
		textview.setText(mTask.getMyName());
		question.setText(mTask.getQuestion());
		
		RadioButton option_1 = (RadioButton)findViewById(R.id.radiogroup_qanda_option_1);
		RadioButton option_2 = (RadioButton)findViewById(R.id.radiogroup_qanda_option_2);
		RadioButton option_3 = (RadioButton)findViewById(R.id.radiogroup_qanda_option_3);
		RadioButton option_4 = (RadioButton)findViewById(R.id.radiogroup_qanda_option_4);
		option_1.setText(mTask.getOptions()[0]);
		option_2.setText(mTask.getOptions()[1]);
		option_3.setText(mTask.getOptions()[2]);
		option_4.setText(mTask.getOptions()[3]);

//		TODO
//		BUTTON
		Button submit = (Button)findViewById(R.id.button_qanda_submit);
		Button hint = (Button)findViewById(R.id.button_qanda_hint);
		submit.setOnClickListener(QAndAActivity.this);
		hint.setOnClickListener(QAndAActivity.this);
	}

//	TODO
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button_qanda_submit:
			Toast.makeText(getApplicationContext(), "Correct! Let's finish another task!", Toast.LENGTH_LONG).show();
			finish();
			break;
		case R.id.button_qanda_hint:
			Toast.makeText(getApplicationContext(), "This is you hint", Toast.LENGTH_SHORT).show();
			break;
		}
	}
}
