package com.cllin.emirates.hackathon.travelpal.mission;

import java.io.Serializable;

import com.cllin.emirates.hackathon.travelpal.task.Task;


@SuppressWarnings("serial")
public class Mission implements Serializable{
	String mName = new String();
	
	int nTask = 10;
	String[] task_names = new String[nTask];
	Task[] mTasks = new Task[nTask];
	
	int mImage = -1;
	int[] task_images = new int[nTask];
	
	public int getTaskNum(){
		return nTask;
	}
	
	public int[] getTaskImages(){
		return task_images;
	}
	
	public String[] getTaskNames(){
		return task_names;
	}
	
	public int getMyImage(){
		return mImage;
	}
	
	public Task[] getTasks(){
		return mTasks;
	}
	
	public Task getTask(int idx){
		return mTasks[idx];
	}
	
	public String getMyName(){
		return mName;
	}
}
