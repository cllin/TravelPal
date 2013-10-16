package com.cllin.emirates.hackathon.travelpal.mission;

import com.cllin.emirates.hackathon.travelpal.activity.R;
import com.cllin.emirates.hackathon.travelpal.task.BrooklynBridge;
import com.cllin.emirates.hackathon.travelpal.task.Task;

@SuppressWarnings("serial")
public class NewYork extends Mission{
	public NewYork(){
		mName = "New York";
		nTask = 10;
		mImage = R.drawable.newyork;
		mTasks = new Task[]{
				new BrooklynBridge()};
		task_names = new String[]{
				"Brooklyn Bridge", "Metropolitan Mesuem of Art",
				"Museum of Modern Art", "Broadway",
				"Flatiron Building", "Central Park",
				"Trinity Church", "Wall Street",
				"United Nation", "The Morgan Library and Museum"		
		};
		task_images = new int[]{
				R.drawable.brooklyn_bridge, R.drawable.metropolitan_museum_of_art, 
				R.drawable.museum_of_modern_art, R.drawable.broadway,
				R.drawable.flatiron_building, R.drawable.central_park,
				R.drawable.trinity_church, R.drawable.wall_street,
				R.drawable.united_nation, R.drawable.morgan_library	
		};
	}
}
