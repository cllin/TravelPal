package com.cllin.emirates.hackathon.travelpal.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.cllin.emirates.hackathon.travelpal.mission.MissionList;

public class MainActivity extends Activity implements OnItemClickListener{
	private static final String KEY_MISSION = "mission";
	private MissionList mMissionList = new MissionList();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_main);
		GridView gridView = (GridView) findViewById(R.id.main_gridView);
		
		int[] images = mMissionList.getImages();
		String[] missions = mMissionList.getMissionNames();
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < missions.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", images[i]);
			item.put("mission", missions[i]);
			items.add(item);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.layout_grid, 
				new String[]{"image", "mission"}, new int[]{R.id.grid_image, R.id.grid_text});
		
		gridView.setNumColumns(1);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(MainActivity.this);
	}
	
	private void switchActivity(int idx){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, MissionActivity.class);
        intent.putExtra(KEY_MISSION, mMissionList.getMission(idx));
        
        startActivity(intent);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView,View view,int position,long id) {
//		TODO
//		Only New York is available now
		if(position != 1){
			Toast.makeText(getApplicationContext(), "Sorry, the mission is not ready yet!", Toast.LENGTH_SHORT).show();
			return;
		}
		switchActivity(position);
	}
}
