package com.example.textrecoapp.gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

import com.example.textrecoapp.App;
import com.example.textrecoapp.ExpandableAdapter;
import com.example.textrecoapp.R;
import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.data.StoryGenerator;
import com.example.textrecoapp.models.StoryMission;
import com.example.textrecoapp.story.StoryModeActivity;
import com.example.textrecoapp.wizards.AbstractWizardActivity;

/**
 * ranked missions will be called (Level 1, Level 2, ...) story missions will
 * have custom names (The Story of Marko Krale, The Macedonian Bloody Wedding
 * story, ...)
 * 
 * @author ivilievs
 */
public class MissionSelectorHandler {

	private Context context;
	private Character character;
	private ExpandableAdapter adapter;
	private Map<String, List<? extends Object>> data;
	private List<String> headers;
	private StoryGenerator storyGenerator;

	// adapter

	public MissionSelectorHandler(Context context) {
		this.context = context;
	}

	private void prepareListData() {
		character = App.getInstance().getCharacterManager().getCharacter();
		storyGenerator = new StoryGenerator();

		headers = new ArrayList<String>();
		headers.add(0, context.getString(R.string.ranked_missions));
		headers.add(1, context.getString(R.string.story_missions));

		data = new HashMap<String, List<? extends Object>>();
		data.put(headers.get(0), getRankedMissions());
		data.put(headers.get(1), getStoryMissions());
	}

	private List<LevelMission> getRankedMissions() {
		List<LevelMission> levels = new ArrayList<LevelMission>();

		for (int i = 1; i <= character.getLatestUnlockedLevel(); i++) {
			levels.add(new LevelMission("Level " + i, i));
		}

		return levels;
	}

	private List<StoryMission> getStoryMissions() {
		return storyGenerator.getStories().get(character.getName());
	}

	public ExpandableAdapter getAdapter() {
		if (adapter == null) {
			prepareListData();
			adapter = new ExpandableAdapter(context, headers, data);
		}
		return adapter;
	}

	private OnChildClickListener listener = new OnChildClickListener() {

		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {

			Object obj = data.get(headers.get(groupPosition))
					.get(childPosition);
			if (obj instanceof LevelMission) {
				// start intent
				LevelMission lm = (LevelMission) obj;
				String text = lm.getName() + ": with id=" + lm.getDifficulty();
				Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
			} else if (obj instanceof StoryMission) {
				StoryMission sm = (StoryMission) obj;
				navigateToStoryWizard(sm);
			}
			return false;
		}
	};

	public OnChildClickListener getChildClickListener() {
		return listener;
	}
	
	private void navigateToStoryWizard(StoryMission sm) {
		Intent intent = new Intent(context, StoryModeActivity.class);
		intent.putExtra(AbstractWizardActivity.EXTRAS_MISSION, sm);
		context.startActivity(intent);
	}
}
