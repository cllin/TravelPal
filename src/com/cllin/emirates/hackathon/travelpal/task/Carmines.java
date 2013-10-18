package com.cllin.emirates.hackathon.travelpal.task;

import com.cllin.emirates.hackathon.travelpal.activity.R;

@SuppressWarnings("serial")
public class Carmines extends Task {
	public Carmines(){
		mName = "Carmine's";
		mImage = R.drawable.carmines;
		descriptions = new String[]{
				"You will be able to order daily special with 15% off if you answer the question correctly",	
				"Locate yourself in the lobby",
				"Take a picture of your favorite Carmine's dish"
		};
		
		QnAQuestion = "What kind of cusine does Carmine's provide?";
		QnAOptions = new String[]{
				"Chinese food", 
				"French food",
				"Italian food",
				"Mexican food"
		};
	}
}
