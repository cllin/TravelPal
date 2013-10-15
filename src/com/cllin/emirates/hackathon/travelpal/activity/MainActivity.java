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
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity{
	private static final String KEY_MISSION_ID = "mission_id";
	private final int[] images = {R.drawable.sanfrancisco, R.drawable.newyork, 
			R.drawable.honolulu, R.drawable.seattle, R.drawable.vegas};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_main);
		GridView gridView = (GridView) findViewById(R.id.main_gridView);
		final String[] list = getResources().getStringArray(R.array.mission_list);
		
		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.length; i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("image", images[i]);
			item.put("mission", list[i]);
			items.add(item);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.layout_grid, 
				new String[]{"image", "mission"}, new int[]{R.id.grid_image, R.id.grid_text});
		
		gridView.setNumColumns(1);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new GridView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapterView,View view,int position,long id) {
				if(position != 1){
					Toast.makeText(getApplicationContext(), "Sorry, the mission is not ready yet!", Toast.LENGTH_SHORT).show();
					return;
				}
				
				switchActivity(position);
			}
		});
	}
	
	private void switchActivity(long idx){
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, MissionActivity.class);
		Bundle bundle = new Bundle();
        bundle.putInt(KEY_MISSION_ID, (int)idx);
        intent.putExtras(bundle);
        
        startActivity(intent);
	}
}
