package com.example.textrecoapp.story;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.textrecoapp.R;

public class FinalStepView implements PageView {

	private Context context;
	private View view;
	private Button button;

	public FinalStepView(Context context) {
		this.context = context;
	}

	private View.OnClickListener btnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Toast.makeText(context, "All story content is erased",
					Toast.LENGTH_SHORT).show();
			
//			StoryModeActivity missionContainer = (StoryModeActivity) context;
//			for(StoryStep step : missionContainer.getStoryMission().getSteps()) {
//				step.setUnlocked(false);
//				missionContainer.finish();
//			}
		}
	};

	private View prepareView() {
		View v = LayoutInflater.from(context)
				.inflate(R.layout.final_step, null);
		button = (Button) v.findViewById(R.id.final_button);
		button.setOnClickListener(btnListener);
		return v;
	}

	@Override
	public View getView() {
		if (view == null) {
			view = prepareView();
		}
		return view;
	}

}
