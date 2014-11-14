package com.example.textrecoapp.models;

import java.io.Serializable;
import java.util.List;

public class StoryMission extends BaseMission implements Serializable {

	private static final long serialVersionUID = 1058784172547470011L;
	
	private int id;
	private String name;
	private String intro;
	private List<StoryStep> steps;
	
	public StoryMission(int id, String name, String intro, List<StoryStep> steps) {
		this.id = id;
		this.intro = intro;
		this.name = name;
		this.steps = steps;
	}
	public String getIntro() {
		return intro;
	}
	
	@Override
	public List<StoryStep> getSteps() {
		return steps;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String getTitle() {
		return name;
	}
}
