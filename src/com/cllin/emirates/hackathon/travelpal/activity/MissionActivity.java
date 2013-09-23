package com.cllin.emirates.hackathon.travelpal.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MissionActivity extends Activity implements OnItemClickListener{
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	
	private static final int MISSION_ID_MOUNTAIN_VIEW = 0;
	private static final int MISSION_ID_PALO_ALTO = 1;
	private static final int MISSION_ID_SUNNYVALE = 2;

	private int mMissionId = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setView();
	}
	
	private void setView(){
		setContentView(R.layout.activity_mission);
		ListView listView = (ListView)findViewById(R.id.listview_tasks);
		
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		
		SimpleAdapter adapter;
		String[] tasks = null;
//		TODO
		String[] descriptions = getResources().getStringArray(R.array.task_list_description);
		
		Bundle bundle = this.getIntent().getExtras();
		mMissionId = bundle.getInt(KEY_MISSION_ID);
		
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
		
		for(int i = 0; i < tasks.length; i++){
			HashMap<String,Object> item = new HashMap<String,Object>();
			item.put("pic", R.drawable.mountain_view);
			item.put("task", tasks[i]);
			item.put("description", descriptions[i]);
			list.add( item );
		}
		
		adapter = new SimpleAdapter(this, list, R.layout.layout_list, new String[] {"pic", "task", "description" }, 
				new int[] {R.id.list_image, R.id.list_title, R.id.list_description});
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}
	
	private void switchActivity(int idx){
		Intent intent = new Intent();
		intent.setClass(MissionActivity.this, TaskActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt(KEY_MISSION_ID, mMissionId);
        bundle.putInt(KEY_TASK_ID, idx);
        intent.putExtras(bundle);
        
        startActivity(intent);
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		switchActivity(position);
	}
}
