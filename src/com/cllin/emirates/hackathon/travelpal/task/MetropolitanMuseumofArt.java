package com.cllin.emirates.hackathon.travelpal.task;

import com.cllin.emirates.hackathon.travelpal.activity.R;

@SuppressWarnings("serial")
public class MetropolitanMuseumofArt extends Task {
	public MetropolitanMuseumofArt(){
		mName = "Metropolitan Museum of Art";
		mImage = R.drawable.metropolitan_museum_of_art;
		descriptions = new String[]{
				"Take a picture from the front of the beautiful building",	
				"Locate yourself in the lobby",
				"Answer the question"
		};
		
		QnAQuestion = "Who is the author of this artwork?";
		QnAOptions = new String[]{
				"Vincent Van Gogh", 
				"Claude Monet",
				"Pierre-Auguste Renoir",
				"Pablo Picasso"
		};
		isQnAHasImage = true;
		mQnAImage = R.drawable.mets_qna_image;
	}
}
