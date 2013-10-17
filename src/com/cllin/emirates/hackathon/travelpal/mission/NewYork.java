package com.cllin.emirates.hackathon.travelpal.mission;

import com.cllin.emirates.hackathon.travelpal.activity.R;
import com.cllin.emirates.hackathon.travelpal.task.BrooklynBridge;
import com.cllin.emirates.hackathon.travelpal.task.Carmines;
import com.cllin.emirates.hackathon.travelpal.task.MetropolitanMuseumofArt;
import com.cllin.emirates.hackathon.travelpal.task.MoMA;
import com.cllin.emirates.hackathon.travelpal.task.Task;
//		TODO
//		Tasks except MoMa, Mets, Brooklyn Bridge, and Carmine's are not implemented

@SuppressWarnings("serial")
public class NewYork extends Mission{
	public NewYork(){
		mName = "New York";
		nTask = 11;
		mImage = R.drawable.newyork;
		mTasks = new Task[]{
				new MetropolitanMuseumofArt(), new MoMA(), 
				new BrooklynBridge(), new Task(),
				new Task(), new Task(),
				new Task(), new Task(),
				new Task(), new Task(),
				new Carmines()
		};
		task_names = new String[]{
				"Metropolitan Museum of Art", "MOMA", 
				"Brooklyn Bridge", "Broadway",
				"Flatiron Building", "Central Park",
				"Trinity Church", "Wall Street",
				"United Nation", "The Morgan Library and Museum",
				"Carmine's"
		};
		task_images = new int[]{
				R.drawable.metropolitan_museum_of_art, R.drawable.moma,
				R.drawable.brooklyn_bridge, R.drawable.broadway,
				R.drawable.flatiron_building, R.drawable.central_park,
				R.drawable.trinity_church, R.drawable.wall_street,
				R.drawable.united_nation, R.drawable.morgan_library,
				R.drawable.carmines
		};
	}
}
