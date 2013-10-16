package com.cllin.emirates.hackathon.travelpal.task;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Task implements Serializable{
	String mName = new String();
	int mImage = -1;
	
	String[] descriptions = new String[3];
	
	String QnAQuestion = new String();
	String[] QnAOptions = new String[4];
	
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
	
	public String getMyName(){
		return mName;
	}
}
