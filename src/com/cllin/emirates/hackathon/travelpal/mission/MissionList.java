package com.cllin.emirates.hackathon.travelpal.mission;

import android.util.Log;

import com.cllin.emirates.hackathon.travelpal.activity.R;

public class MissionList {

	private static final Mission[] missions = {
		new SanFrancisco(), new NewYork(),
		new Honolulu(), new Seattle(),
		new Vegas()
	};
	
	private static final String[] mission_names = {
		"San Francisco", "New York",
		"Honolulu", "Seattle",
		"Vegas"
	};
	
	private static final int[] images = {
		R.drawable.sanfrancisco, R.drawable.newyork, 
		R.drawable.honolulu, R.drawable.seattle, R.drawable.vegas
	};
	
	public Mission getMission(int idx){
		Log.d("MissionList", "Name="+missions[idx].getMyName());
		return missions[idx];
	}
	
	public String[] getMissionNames(){
		return mission_names;
	}
	
	public int[] getImages(){
		return images;
	}
}
