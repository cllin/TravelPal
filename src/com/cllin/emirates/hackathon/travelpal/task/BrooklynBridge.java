package com.cllin.emirates.hackathon.travelpal.task;

import com.cllin.emirates.hackathon.travelpal.activity.R;

@SuppressWarnings("serial")
public class BrooklynBridge extends Task {
	public BrooklynBridge(){
		mName = "Brooklyn Bridge";
		mImage = R.drawable.brooklyn_bridge;
		descriptions = new String[]{
				"Take a picture with the famous bridge",	
				"Locate yourself in center of the bridge",
				"Answer the question"
		};
		
		QnAQuestion = "How many years has the Brooklyn bridge been built?";
		QnAOptions = new String[]{
				"180", "130", "90", "50"
		};
	}
	
	public void setMyImage(int image){
		mImage = image;
	}
	
	public int getMyImage(){
		return mImage;
	}
	
	public String[] getDescriptions(){
		return descriptions;
	}
	
	public String getQuestion(){
		return QnAQuestion;
	}
	
	public String[] getOptions(){
		return QnAOptions;
	}
}
