/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textrecoapp.CharacterSelectorActivity;
import com.example.textrecoapp.OCRActivity;
import com.example.textrecoapp.R;
import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.data.ArtifactsGenerator;

public class CharacterMissionHandler {

  private Context context;
  private LayoutInflater layoutInflater;

  private int lockedDifficultyColor;
  private int currentDifficultyColor;
  private int unlockedDifficultyColor;

  // views
  private TextView characterTitle;
  private TextView characterDescription;
  private LinearLayout difficultyContainer;
  private Button startNewMissionBtn;
  private TextView missionTitle;
  private TextView missionDescription;
  private View missionProgressContainer;
  private TextView missionProgress;
  private Button findArtifactBtn;

  private Character character;

  public CharacterMissionHandler(Context context) {
    this.context = context;
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    lockedDifficultyColor = android.R.color.darker_gray;
    currentDifficultyColor = android.R.color.holo_green_dark;
    unlockedDifficultyColor = android.R.color.holo_blue_dark;
  }

  public void handleMissionForCharacter(Character character, ViewGroup leftPanel, ViewGroup rightPanel) {
    this.character = character;
    // inflate layouts
    inflateLeftPanel(leftPanel);
    inflateRightPanel(rightPanel);

    // populate always known data
    characterTitle.setText(character.getName());
    String templateString = context.getResources().getString(R.string.character_description_template);
    String charDescription = String.format(templateString, character.getCategory());
    characterDescription.setText(charDescription);

    // FIXME: currently, the name of the character is the category (should be fixed for each
    // artifact in ArtifactsGenerator)
    populateDifficultyLevels(character.getName(), character.getLatestUnlockedLevel());

    // check idle vs. current mission behavior
    if (character.getState() == Character.STATE_IDLE) {
      missionTitle.setText(context.getResources().getString(R.string.no_mission_in_progress));
      missionDescription.setText("\"" + context.getResources().getString(R.string.how_to_start_mission) + "\"");
      findArtifactBtn.setVisibility(View.GONE);
      missionProgressContainer.setVisibility(View.GONE);
    } else {
      int missionDificulty = character.getMission().getDifficulty();
      missionTitle.setText(character.getMission().getTitle());
      missionDescription.setText(formatMissionDescription(missionDificulty));

      highlightCurrentMissionDifficulty(missionDificulty);

      // mission progress
      missionProgress.setText(character.getMission().getMissionProgress());
      findArtifactBtn.setVisibility(View.VISIBLE);
      missionProgressContainer.setVisibility(View.VISIBLE);
    }

    startNewMissionBtn.setOnClickListener(startNewMissionListener);
    findArtifactBtn.setOnClickListener(findArtefactListener);
  }

  private View.OnClickListener startNewMissionListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      if (character.getState() == Character.STATE_IDLE) {
        // generate mission
        // TODO: store the selected difficulty level
        // FIXME: currently, the name of the character is the category (should be fixed for each
        // artifact in ArtifactsGenerator)
        // TODO: extract the code below in a runnable object that will be passed as a result in the
        // dialog passed in the else brackets
        MissionContext mission =
            MissionGenerator.getInstance().generateMissionForCharacter(context, character.getName(), 1);
        character.setMission(mission);
        // update right panel
        updateRightPanelWithMission();
      } else {
        Toast.makeText(context, "show dialog if user wants to stop current mission", Toast.LENGTH_SHORT).show();
      }
    }
  };

  private void updateRightPanelWithMission() {
    int missionDificulty = character.getMission().getDifficulty();

    missionTitle.setText(character.getMission().getTitle());
    missionDescription.setText(formatMissionDescription(missionDificulty));
    missionProgress.setText(character.getMission().getMissionProgress());
    missionProgressContainer.setVisibility(View.VISIBLE);
    findArtifactBtn.setVisibility(View.VISIBLE);
    highlightCurrentMissionDifficulty(missionDificulty);
  }

  private String formatMissionDescription(int difficulty) {
    String difficultyDescription = GameplayUtils.getDifficultyDescriptor(context, difficulty);
    String templateString2 = context.getResources().getString(R.string.mission_description_template);
    String formattedString = String.format(templateString2, difficultyDescription, character.getCategory());
    return formattedString;
  }

  private View.OnClickListener findArtefactListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      CharacterSelectorActivity activity = (CharacterSelectorActivity) context;

      Intent intent = new Intent(context, OCRActivity.class);
      intent.putExtra(OCRActivity.EXTRAS_CHARACTER, character);
      activity.startActivityForResult(intent, CharacterSelectorActivity.REQ_CODE_OCR);
    }
  };

  private void highlightCurrentMissionDifficulty(int missionDificulty) {
    for (int i = 0; i < difficultyContainer.getChildCount(); i++) {
      ViewGroup v = (ViewGroup) difficultyContainer.getChildAt(i);
      TextView tv = (TextView) v.getChildAt(0);
      if (Integer.parseInt(String.valueOf(tv.getText())) == missionDificulty) {
        tv.setBackgroundResource(currentDifficultyColor);
        break;
      }
    }
  }

  private void inflateLeftPanel(ViewGroup leftPanel) {
    if (characterTitle == null) {
      View leftPanelContent = layoutInflater.inflate(R.layout.left_panel_layout, leftPanel);
      characterTitle = (TextView) leftPanelContent.findViewById(R.id.character_title);
      characterDescription = (TextView) leftPanelContent.findViewById(R.id.character_description);
      difficultyContainer = (LinearLayout) leftPanelContent.findViewById(R.id.difficulty_conatainer);
      startNewMissionBtn = (Button) leftPanelContent.findViewById(R.id.start_newgame_btn);
    }
  }

  private void inflateRightPanel(ViewGroup rightPanel) {
    if (missionTitle == null) {
      View rightPanelContent = layoutInflater.inflate(R.layout.right_panel_layout, rightPanel);
      missionTitle = (TextView) rightPanelContent.findViewById(R.id.mission_title);
      missionProgress = (TextView) rightPanelContent.findViewById(R.id.mission_progress);
      missionProgressContainer = rightPanelContent.findViewById(R.id.mission_progress_container);
      missionDescription = (TextView) rightPanelContent.findViewById(R.id.mission_description);
      findArtifactBtn = (Button) rightPanelContent.findViewById(R.id.find_artifact_btn);
    }
  }

  private void populateDifficultyLevels(String category, int latestUnlocked) {

    difficultyContainer.removeAllViews();

    int totalLvls = ArtifactsGenerator.getInstance().getTotalLevelsForCategory(category);
    for (int i = 1; i <= totalLvls; i++) {
      View diffLayout = layoutInflater.inflate(R.layout.difficulty_level, null);
      TextView tv = (TextView) diffLayout.findViewById(R.id.diff_tv);
      tv.setText(String.valueOf(i));
      if (i <= latestUnlocked) {
        tv.setBackgroundResource(unlockedDifficultyColor);
      } else {
        tv.setBackgroundResource(lockedDifficultyColor);
        tv.setEnabled(false);
      }
      tv.setOnClickListener(difficultyListener);
      difficultyContainer.addView(diffLayout);
    }
  }

  private View.OnClickListener difficultyListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      TextView tv = (TextView) v;
      Toast.makeText(context, tv.getText() + " was clicked", Toast.LENGTH_SHORT).show();
    }
  };

  public void handleResultFromOCR(String result) {
    Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
  }

}
