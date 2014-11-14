/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import java.util.List;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textrecoapp.App;
import com.example.textrecoapp.R;
import com.example.textrecoapp.UiUtils;
import com.example.textrecoapp.achievements.Achievement;
import com.example.textrecoapp.achievements.AchievementsActivity;
import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.data.StoryGenerator;
import com.example.textrecoapp.models.StoryMission;
import com.example.textrecoapp.story.StoryModeActivity;
import com.example.textrecoapp.wizards.AbstractWizardActivity;

public class CharacterMissionHandler implements IMissionSelectionListener {

	private Context context;
	private LayoutInflater layoutInflater;

	// views
	private TextView characterTitle;
	private TextView characterDescription;
	private ExpandableListView listView;

	private int userSelectedDifficulty;
	private StoryGenerator storyGenerator;
	private boolean isRankedSelected;

	public CharacterMissionHandler(Context context) {
		this.context = context;
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		storyGenerator = new StoryGenerator();
	}

	public void handleMissionForCharacter(String characterName,
			ViewGroup leftPanel, ViewGroup rightPanel) {
		App.getInstance().getCharacterManager().changeCharacter(characterName);
		userSelectedDifficulty = -1;

		// inflate layouts
		inflateLeftPanel(leftPanel);
		inflateRightPanel(rightPanel);

		updatePanels();
	}

	private Runnable missionGenerator = new Runnable() {

		@Override
		public void run() {
			Character character = App.getInstance().getCharacterManager()
					.getCharacter();
			MissionContext mission = MissionGenerator.getInstance()
					.generateMissionForCharacter(context,
							character.getCategory(), userSelectedDifficulty);
			character.setMission(mission);
		}
	};

	private void updatePanels() {
		Character character = App.getInstance().getCharacterManager()
				.getCharacter();

		// populate always known data
		characterTitle.setText(character.getName());
		String templateString = context.getResources().getString(
				R.string.character_description_template);
		String charDescription = String.format(templateString,
				character.getCategory());
		characterDescription.setText(charDescription);
	}

	private void inflateLeftPanel(ViewGroup leftPanel) {
		if (characterTitle == null) {
			View leftPanelContent = layoutInflater.inflate(
					R.layout.left_panel_layout, leftPanel);

			characterTitle = (TextView) leftPanelContent
					.findViewById(R.id.character_title);
			characterDescription = (TextView) leftPanelContent
					.findViewById(R.id.character_description);
		}
	}

	private void inflateRightPanel(ViewGroup rightPanel) {
		if (listView == null) {
			View rightPanelContent = layoutInflater.inflate(
					R.layout.right_panel_layout, rightPanel);
			listView = (ExpandableListView) rightPanelContent
					.findViewById(R.id.exp_list);
			MissionSelectorHandler listSelector = new MissionSelectorHandler(context);
			listView.setAdapter(listSelector.getAdapter());
			listView.setOnChildClickListener(listSelector.getChildClickListener());
		}
	}

	//TODO: move to ranked mission wizard
	public void handleResultFromOCR(int result) {
		Character character = App.getInstance().getCharacterManager()
				.getCharacter();
		switch (result) {
		case MissionContext.STAGE_PASSED:
			Toast.makeText(context,
					context.getString(R.string.mission_stage_passed),
					Toast.LENGTH_SHORT).show();
			break;

		case MissionContext.STAGE_FAILED:
			// do nothing
			Toast.makeText(context,
					context.getString(R.string.mission_stage_failed),
					Toast.LENGTH_SHORT).show();
			break;

		case MissionContext.MISSION_COMPLETE:
			Toast.makeText(context,
					context.getString(R.string.mission_finished),
					Toast.LENGTH_SHORT).show();

			List<Achievement> unlockedAchievements = App.getInstance()
					.getAchievementChecker()
					.checkAchievements(character.getMission());

			showUnlockedAchievements(unlockedAchievements);

			// update unlocked level
			character.unlockNewLevel();
			// remove the mission
			character.setMission(null);
			break;
		}
		updatePanels();
	}

	private void showUnlockedAchievements(List<Achievement> unlockedAchievements) {
		if (unlockedAchievements.size() == 0) {
			return;
		}
		CharSequence[] achievements = new CharSequence[unlockedAchievements
				.size()];
		int index = 0;
		for (Achievement a : unlockedAchievements) {
			achievements[index++] = a.getName();
		}

		String title = context.getString(R.string.title_unlocked_dialog);
		String posBtnText = context.getString(R.string.goto_achievements);
		String negBtnText = context.getString(R.string.cancel);

		DialogInterface.OnClickListener positiveListener = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(context, AchievementsActivity.class);
				context.startActivity(intent);
			}
		};

		UiUtils.createDialogWithList(context, title, achievements, posBtnText,
				negBtnText, positiveListener, UiUtils.getNegListener()).show();
		;
	}

	@Override
	public void digestSelection(int result) {
		if (isRankedSelected) {
			userSelectedDifficulty = result;
			missionGenerator.run();
			updatePanels();
		} else {
			Character character = App.getInstance().getCharacterManager()
					.getCharacter();
			character.setStory(getStoryById(result));

			Intent intent = new Intent(context, StoryModeActivity.class);
			intent.putExtra(AbstractWizardActivity.EXTRAS_MISSION,
					character.getStory());
			context.startActivity(intent);
		}
	}

	private StoryMission getStoryById(int id) {
		Character currentCharacter = App.getInstance().getCharacterManager()
				.getCharacter();
		List<StoryMission> stories = storyGenerator.getStories().get(
				currentCharacter.getName());
		for (StoryMission story : stories) {
			if (story.getId() == id) {
				return story;
			}
		}
		return null;
	}

}
