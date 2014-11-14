package com.example.textrecoapp.models;

import java.io.Serializable;
import java.util.List;

public abstract class BaseMission implements Serializable {

	private static final long serialVersionUID = -2236138619110347615L;
	public abstract List<? extends StoryStep> getSteps();
	public abstract String getTitle();
}
