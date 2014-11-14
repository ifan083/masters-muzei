package com.example.textrecoapp.story;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.textrecoapp.R;
import com.example.textrecoapp.UiUtils;
import com.example.textrecoapp.models.StoryMission;
import com.example.textrecoapp.models.StoryStep;
import com.example.textrecoapp.wizards.AbstractWizardActivity;

public class StoryModeActivity extends AbstractWizardActivity {

	private AlertDialog introDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getInfoButton().setOnClickListener(introListener);
		prepareDialog();
		if (getCurrent() == 0) {
			introDialog.show();
		}
	}

	private void prepareDialog() {
		StoryMission sm = (StoryMission) getMission();
		introDialog = UiUtils.createSimpleCancelDialog(this,
				getString(R.string.story_intro), sm.getIntro());
	}

	private View.OnClickListener introListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			introDialog.show();
		}
	};

	@Override
	public PageView getFinalStepView() {
		return new FinalStepView(this);
	}

	@Override
	public PageView getStepView(StoryStep step) {
		return new StoryStepView(this, step);
	}

	@Override
	public int getBackgroundResource() {
		return R.drawable.story_background;
	}

}
