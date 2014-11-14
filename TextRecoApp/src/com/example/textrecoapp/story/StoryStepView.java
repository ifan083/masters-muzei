package com.example.textrecoapp.story;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.textrecoapp.R;
import com.example.textrecoapp.ar.ScanningResult;
import com.example.textrecoapp.models.StoryStep;

public class StoryStepView implements PageView, ScanningResult {

	private Context context;
	private StoryStep step;
	private View view;

	private TextView tv;
	private TextView description;

	private TextView solvedMessage;
	private View scanContainer;
	private Button scanButton;

	public StoryStepView(Context context, StoryStep step) {
		this.step = step;
		this.context = context;
	}

	private View prepareView() {
		View v = LayoutInflater.from(context)
				.inflate(R.layout.story_step, null);
		tv = (TextView) v.findViewById(R.id.step_name);
		description = (TextView) v.findViewById(R.id.step_description);

		solvedMessage = (TextView) v.findViewById(R.id.solved_message);
		scanButton = (Button) v.findViewById(R.id.step_scan);
		scanContainer = v.findViewById(R.id.step_scan_conatainer);

		populateViews();
		return v;
	}

	private void populateViews() {

		if (step.isUnlocked()) {
			tv.setText(step.getArtifact().getName());
			solvedMessage.setVisibility(View.VISIBLE);
			scanContainer.setVisibility(View.GONE);
		} else {
			tv.setText("???");
			solvedMessage.setVisibility(View.GONE);
			scanContainer.setVisibility(View.VISIBLE);
		}
		description.setText(step.getDescription());
		scanButton.setOnClickListener(scanListener);
	}

	private View.OnClickListener scanListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO: listener for the result
//			Intent intent = new Intent(context, OCRActivity.class);
//			context.startActivity(intent);
			// put listener
		}
	};

	@Override
	public View getView() {
		if (view == null) {
			view = prepareView();
		}
		return view;
	}

	@Override
	public void onScanningFinished(String resultString) {
		if (resultString.equals(step.getArtifact().getName())) {

		} else {
			// handle wrong result
		}
	}

}
