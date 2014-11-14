/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import java.io.Serializable;
import java.util.List;

import com.example.textrecoapp.models.BaseMission;
import com.example.textrecoapp.models.StoryStep;

public class MissionContext extends BaseMission implements Serializable {

	private static final long serialVersionUID = -7641306858667745284L;

	public static final int STAGE_FAILED = 0;
	public static final int STAGE_PASSED = 1;
	public static final int MISSION_COMPLETE = 2;

	private int difficulty;
	private String name;
	private List<MissionStage> stages;
	private int current;

	public MissionContext(String title, int difficulty,
			List<MissionStage> stages) {
		this.name = title;
		this.stages = stages;
		this.difficulty = difficulty;
		current = 0;
	}

	public List<MissionStage> getStages() {
		return stages;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int tryAnswer(String newTry) {
		boolean isCorrect = stages.get(current).tryAnswer(newTry);

		if (!isCorrect) {
			return STAGE_FAILED;
		} else {
			if (current == stages.size() - 1) {
				return MISSION_COMPLETE;
			}

			current++;
			return STAGE_PASSED;
		}

	}

	public String getHint() {
		return stages.get(current).getHint();
	}

	public Artifact getArtifact() {
		return stages.get(current).getArtifact();
	}

	@Override
	public List<? extends StoryStep> getSteps() {
		return stages;
	}

	@Override
	public String getTitle() {
		return name;
	}
}
