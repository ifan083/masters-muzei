package com.example.textrecoapp.models;

import java.io.Serializable;

import com.example.textrecoapp.gameplay.Artifact;

public class StoryStep implements Serializable {

	private static final long serialVersionUID = 4872841770898025454L;
	
	private Artifact artifact;
	private String description;
	private boolean isUnlocked;

	public StoryStep(Artifact artifact, String description) {
		this.artifact = artifact;
		this.description = description;
		isUnlocked = false;
	}

	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void unlockStoryArtifact() {
		isUnlocked = true;
	}

	public boolean isUnlocked() {
		return isUnlocked;
	}
	
	public void setUnlocked(boolean isUnlocked) {
		this.isUnlocked = isUnlocked;
	}

}
