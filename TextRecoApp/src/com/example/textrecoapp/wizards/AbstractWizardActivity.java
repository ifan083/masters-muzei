package com.example.textrecoapp.wizards;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.example.textrecoapp.R;
import com.example.textrecoapp.models.BaseMission;
import com.example.textrecoapp.models.StoryStep;
import com.example.textrecoapp.story.NonSwipableViewPager;
import com.example.textrecoapp.story.PageView;
import com.example.textrecoapp.story.StoryPagerAdapter;

public abstract class AbstractWizardActivity extends Activity {

	public static final String EXTRAS_MISSION = "mission";
	
	private int current;
	private int total;
	private int stepSize;
	
	private LinearLayout background;
	private NonSwipableViewPager pager;
	private TextView storyTitle;
	private View progress;
	private TextView percentage;
	private Button prev;
	private Button next;
	private Button exit;
	private Button info;
	
	private BaseMission mission;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.story_activity);
		
		mission = (BaseMission) getIntent().getExtras().get(EXTRAS_MISSION);
		
		inflateViews();
		populateViews();
		createChildViewsAndPopulatePager();
		initProgress();
		detectResolvedStatus();
		handleProgress();
	}
	
	protected void inflateViews() {
		background = (LinearLayout) findViewById(R.id.background);
		pager = (NonSwipableViewPager) findViewById(R.id.pager);
		storyTitle = (TextView) findViewById(R.id.story_name);
		progress = findViewById(R.id.progress_current);
		percentage = (TextView) findViewById(R.id.progress_percentage);
		prev = (Button) findViewById(R.id.button_prev);
		next = (Button) findViewById(R.id.button_next);
		exit = (Button) findViewById(R.id.exit_story);
		info = (Button) findViewById(R.id.intro_story);
	}
	
	protected void populateViews() {
		background.setBackgroundResource(getBackgroundResource());
		storyTitle.setText(mission.getTitle());
		prev.setOnClickListener(prevListener);
		next.setOnClickListener(nextListener);
		exit.setOnClickListener(exitListener);
	}
	
	private void initProgress() {
		total = mission.getSteps().size();

		int totalWidth = getResources().getDisplayMetrics().widthPixels;
		totalWidth -= 2 * getResources().getDimensionPixelOffset(
				R.dimen.progress_margin);
		stepSize = totalWidth / total;
	}
	
	protected void detectResolvedStatus() {
		current = 0;
		for(StoryStep step : mission.getSteps()) {
			if(step.isUnlocked()) {
				current++;
			} else {
				break;
			}
		}
	}
	
	private View.OnClickListener prevListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (current > 0) {
				current--;
				pager.setCurrentItem(current, false);
				handleProgress();
			}
		}
	};

	private View.OnClickListener nextListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (current <= total) {
				current++;
				pager.setCurrentItem(current, false);
				handleProgress();
			}
		}
	};

	private View.OnClickListener exitListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AbstractWizardActivity.this.finish();
		}
	};
	
	private void handleProgress() {
		LinearLayout.LayoutParams params = (LayoutParams) progress
				.getLayoutParams();
		params.width = current * stepSize;
		progress.setLayoutParams(params);

		float percent = (current / (float) total) * 100;
		int percentInt = (int) percent;
		percentage.setText(percentInt + "%");
	}
	
	private void createChildViewsAndPopulatePager() {
		List<PageView> stepViews = new ArrayList<PageView>();
		for (StoryStep step : mission.getSteps()) {
			PageView stepView = getStepView(step);
			stepViews.add(stepView);
		}
		PageView finalStep = getFinalStepView();
		stepViews.add(finalStep);
		StoryPagerAdapter adapter = new StoryPagerAdapter(stepViews);
		pager.setAdapter(adapter);
	}
	
	
	public BaseMission getMission() {
		return mission;
	}
	
	public int getCurrent() {
		return current;
	}
	
	public Button getInfoButton() {
		return info;
	}
	
	public abstract PageView getFinalStepView();
	
	public abstract PageView getStepView(StoryStep step);
	
	public abstract int getBackgroundResource();
	
//	TODO: onDestroy save the state in file (serialize it)
}
