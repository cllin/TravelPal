package com.cllin.emirates.hackathon.travelpal.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class CameraActivity extends Activity implements Callback, OnClickListener {
	public static final String MSG_TAG = "CameraActivity";
	private static final String KEY_MISSION_ID = "mission_id";
	private static final String KEY_TASK_ID = "task_id";
	
//	VIEW
	private SurfaceView mSurfaceView;
	private SurfaceHolder mSurfaceHolder;
	
//	CAMERA
	private Camera mCamera;
	
	private int mTaskId = -1;
	private int mMissionId = -1;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_camera);
		this.setRequestedOrientation(1);
		
		getBundle();
		setView();
		findControl();
	}
	
	private void getBundle(){
		Bundle bundle = this.getIntent().getExtras();
		mMissionId = bundle.getInt(KEY_MISSION_ID);
		mTaskId = bundle.getInt(KEY_TASK_ID);
	}
	
	private void setView(){
		mSurfaceView = (SurfaceView) findViewById(R.id.cameraSurfaceView);
		Button takeBtn = (Button)findViewById(R.id.button_camera_take);
		takeBtn.setOnClickListener(CameraActivity.this);
	}
	
	private void goBack(){
		finish();
	}

	private void findControl(){
		mSurfaceHolder = mSurfaceView.getHolder();
		mSurfaceHolder.addCallback(this);
	}

	@Override
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h){
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setFocusMode("auto");
        mCamera.setParameters(parameters);
        mCamera.startPreview();
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder){
		try{
			mCamera = Camera.open();
			mCamera.setPreviewDisplay(mSurfaceHolder);
            mCamera.setDisplayOrientation(90);
        }catch (IOException e){
        	mCamera.release();
        	mCamera = null;
        }
	}
	
    @Override
	public void surfaceDestroyed(SurfaceHolder holder){
    	mCamera.stopPreview();
    	mCamera.release();
    	mCamera = null;
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.button_camera_take) {
			mCamera.takePicture(null, null, mPictureCallback);
		}
	}
	
	private PictureCallback mPictureCallback = new PictureCallback() {
		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			File pictureFile = getOutputMediaFile();
			if (pictureFile == null){
				Log.d(MSG_TAG, "Error creating media file, check storage permissions");
				return;
			}else{
				Log.d(MSG_TAG, "Path: " + pictureFile.getAbsolutePath());
			}

			try {
				FileOutputStream fos = new FileOutputStream(pictureFile);
				fos.write(data);
				fos.close();
			} catch (FileNotFoundException e) {
				Log.d(MSG_TAG, "Error: " + e.getMessage());
			} catch (IOException e) {
				Log.d(MSG_TAG, "Error: " + e.getMessage());
			}
			
			goBack();
		}
	};
	
	private File getOutputMediaFile(){
	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "TravelBuddy");
	    
	    if (! mediaStorageDir.exists()){
	    	if (! mediaStorageDir.mkdirs()){
	    		return null;
	    	}
	    }

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
	    String missionStamp = "M" + mMissionId + "T" + mTaskId;
	    
	    File mediaFile;
	    mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + missionStamp + "_" + timeStamp + ".jpg");
	    
	    return mediaFile;
	}
}
