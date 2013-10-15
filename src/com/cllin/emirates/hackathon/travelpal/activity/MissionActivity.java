package com.cllin.emirates.hackathon.travelpal.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	private static final String KEY_IMAGE_ID = "image_id";

	private static final int[] images = {
		R.drawable.brooklyn_bridge, R.drawable.metropolitan_museum_of_art, 
		R.drawable.museum_of_modern_art, R.drawable.broadway,
		R.drawable.flatiron_building, R.drawable.central_park,
		R.drawable.trinity_church, R.drawable.wall_street,
		R.drawable.united_nation, R.drawable.morgan_library
	}; 
	
	private int mMissionId = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_mission);
		GridView gridView = (GridView) findViewById(R.id.mission_gridView);
//		TODO
		final String[] list = getResources().getStringArray(R.array.task_list_newyork);
		
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", images[i]);
			item.put("task", list[i]);
			items.add(item);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.layout_grid, 
				new String[]{"image", "task"}, new int[]{R.id.grid_image, R.id.grid_text});
		
		gridView.setNumColumns(1);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new GridView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView,View view,int position,long id) {
				if(position != 0){
					Toast.makeText(getApplicationContext(), "Sorry, the task is not ready yet!", Toast.LENGTH_SHORT).show();
					return;
				}
				
				switchActivity(position);
			}
		});
	}
	
	private void switchActivity(int idx){
		Intent intent = new Intent();
		intent.setClass(MissionActivity.this, TaskActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt(KEY_MISSION_ID, mMissionId);
        bundle.putInt(KEY_TASK_ID, idx);
        bundle.putInt(KEY_IMAGE_ID, images[idx]);
        intent.putExtras(bundle);
        
        startActivity(intent);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		switchActivity(position);
	}
}
