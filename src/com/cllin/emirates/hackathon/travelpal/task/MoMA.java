package com.cllin.emirates.hackathon.travelpal.task;

import com.cllin.emirates.hackathon.travelpal.activity.R;

@SuppressWarnings("serial")
public class MoMA extends Task {
	public MoMA(){
		mName = "MoMA";
		mImage = R.drawable.moma;
		descriptions = new String[]{
				"Take a picture with the famous building",	
				"Locate yourself in the lobby",
				"Answer the question"
		};
		
		QnAQuestion = "Which of these facts about this stunning painting, The Starry Night, are TRUE?";
		QnAOptions = new String[]{
				"It was painted by Vincent Van Gogh", 
				"The painting depicts a star-filled night sky, cypress trees, and a distant village",
				"It was painted in 1889",
				"All of above"
		};
	}
}
