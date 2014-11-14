/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.characters;

import java.io.Serializable;

import com.example.textrecoapp.App;
import com.example.textrecoapp.gameplay.MissionContext;
import com.example.textrecoapp.models.StoryMission;

/**
 * AKA Category.
 */
public class Character implements Serializable {

	private static final long serialVersionUID = 2100891000937263976L;

	public static final int KNOWLEDGE_BASIC = 1;
	public static final int KNOWLEDGE_INTERMEDIATE = 2;
	public static final int KNOWLEDGE_SUPERIOR = 3;
	public static final int KNOWLEDGE_EXPERT = 4;

	private MissionContext mission;
	private StoryMission story;
	private String name;
	private String category;
	private String pictureFilename;
	private int latestUnlockedLevel;
	private boolean state;

	public Character(String name, String category, String pictureFilename) {

		this.name = name;
		this.category = category;
		this.pictureFilename = pictureFilename;

		latestUnlockedLevel = 1;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getPictureFilename() {
		return pictureFilename;
	}

	public boolean getState() {
		return state;
	}

	public void changeState(boolean state) {
		this.state = state;
	}

	public int getLatestUnlockedLevel() {
		return latestUnlockedLevel;
	}

	public MissionContext getMission() {
		return mission;
	}

	public void setMission(MissionContext mission) {
		this.mission = mission;
	}

	public void unlockNewLevel() {
		int total = App.getInstance().getCartographer()
				.getTotalLevelsForCategory(category);
		if (total > latestUnlockedLevel) {
			latestUnlockedLevel++;
		}
	}

	public StoryMission getStory() {
		return story;
	}

	public void setStory(StoryMission story) {
		this.story = story;
	}
}
