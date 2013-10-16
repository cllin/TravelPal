package com.cllin.emirates.hackathon.travelpal.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cllin.emirates.hackathon.travelpal.mission.Mission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MissionActivity extends Activity implements OnItemClickListener{
	private static final String KEY_MISSION = "mission";
	private static final String KEY_TASK = "task";
	private Mission mMission = new Mission();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		Intent intent = getIntent();
		mMission = (Mission) intent.getSerializableExtra(KEY_MISSION);
		
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_mission);
		GridView gridView = (GridView) findViewById(R.id.mission_gridView);
		
		String[] tasks = mMission.getTaskNames();
		int[] images = mMission.getTaskImages();
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < mMission.getTaskNum(); i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", images[i]);
			item.put("task", tasks[i]);
			items.add(item);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.layout_grid, 
				new String[]{"image", "task"}, new int[]{R.id.grid_image, R.id.grid_text});
		
		gridView.setNumColumns(1);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(MissionActivity.this);
	}
	
	private void switchActivity(int idx){
		Intent intent = new Intent();
		intent.setClass(MissionActivity.this, TaskActivity.class);
		intent.putExtra(KEY_TASK, mMission.getTask(idx));
		
		startActivity(intent);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//		TODO
//		Only Brooklyn Bridge is available now
		if(position != 0){
			Toast.makeText(getApplicationContext(), "Sorry, the task is not ready yet!", Toast.LENGTH_SHORT).show();
			return;
		}
		switchActivity(position);
	}
}
