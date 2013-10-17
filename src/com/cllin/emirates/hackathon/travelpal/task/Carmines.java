package com.cllin.emirates.hackathon.travelpal.task;

import com.cllin.emirates.hackathon.travelpal.activity.R;

@SuppressWarnings("serial")
public class Carmines extends Task {
	public Carmines(){
		mName = "Carmine's";
		mImage = R.drawable.carmines;
		descriptions = new String[]{
				"Order the daily special with 15% off discount and take a picture of it",	
				"Locate yourself in the lobby",
				"Answer the question"
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
