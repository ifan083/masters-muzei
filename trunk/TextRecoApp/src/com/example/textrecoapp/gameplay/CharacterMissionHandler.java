/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    populateDifficultyLevels(character.getCategory(), character.getLatestUnlockedLevel());

    // check idle vs. current mission behavior
    if (character.getState() == Character.STATE_IDLE) {
      missionTitle.setText(context.getResources().getString(R.string.no_mission_in_progress));
      missionDescription.setText(context.getResources().getString(R.string.how_to_start_mission));
      findArtifactBtn.setVisibility(View.GONE);
    } else {
      int missionDificulty = character.getMission().getDifficulty();
      String difficultyDescription = getDifficultyDescriptor(missionDificulty);
      missionTitle.setText(character.getCategory() + " " + difficultyDescription);
      String templateString2 = context.getResources().getString(R.string.mission_description_template);
      String formattedString = String.format(templateString2, difficultyDescription, character.getCategory());
      missionDescription.setText(formattedString);

      highlightCurrentMissionDifficulty(missionDificulty);

      // mission progress
      missionProgress.setText(character.getMission().getMissionProgress());
      findArtifactBtn.setVisibility(View.VISIBLE);
    }

    startNewMissionBtn.setOnClickListener(startNewMissionListener);
    findArtifactBtn.setOnClickListener(findArtefactListener);
  }

  private View.OnClickListener startNewMissionListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      if (character.getState() == Character.STATE_IDLE) {
        Toast.makeText(context, "generate new mission", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(context, "show dialog if user wants to stop current mission", Toast.LENGTH_SHORT).show();
      }
      Toast.makeText(context, "start new mission", Toast.LENGTH_SHORT).show();
    }
  };

  private View.OnClickListener findArtefactListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Toast.makeText(context, "redirect to OCR screen", Toast.LENGTH_SHORT).show();
    }
  };

  private void highlightCurrentMissionDifficulty(int missionDificulty) {
    for (int i = 0; i < difficultyContainer.getChildCount(); i++) {
      TextView tv = (TextView) difficultyContainer.getChildAt(i);
      if (Integer.parseInt(String.valueOf(tv.getText())) == missionDificulty) {
        tv.setBackgroundResource(currentDifficultyColor);
        break;
      }
    }
  }

  private void inflateLeftPanel(ViewGroup leftPanel) {
    View leftPanelContent = layoutInflater.inflate(R.layout.left_panel_layout, leftPanel);
    characterTitle = (TextView) leftPanelContent.findViewById(R.id.character_title);
    characterDescription = (TextView) leftPanelContent.findViewById(R.id.character_description);
    difficultyContainer = (LinearLayout) leftPanelContent.findViewById(R.id.difficulty_conatainer);
    startNewMissionBtn = (Button) leftPanelContent.findViewById(R.id.start_newgame_btn);
  }

  private void inflateRightPanel(ViewGroup rightPanel) {
    View rightPanelContent = layoutInflater.inflate(R.layout.left_panel_layout, rightPanel);
    missionTitle = (TextView) rightPanelContent.findViewById(R.id.mission_title);
    missionProgress = (TextView) rightPanelContent.findViewById(R.id.mission_progress);
    missionDescription = (TextView) rightPanelContent.findViewById(R.id.mission_description);
    findArtifactBtn = (Button) rightPanelContent.findViewById(R.id.find_artifact_btn);
  }

  private void populateDifficultyLevels(String category, int latestUnlocked) {
    int totalLvls = ArtifactsGenerator.getInstance().getTotalLevelsForCategory(category);
    for (int i = 1; i <= totalLvls; i++) {
      TextView tv = (TextView) layoutInflater.inflate(R.layout.difficulty_level, null);
      tv.setText(String.valueOf(i));
      if (i <= latestUnlocked) {
        tv.setBackgroundResource(unlockedDifficultyColor);
      } else {
        tv.setBackgroundResource(lockedDifficultyColor);
        tv.setEnabled(false);
      }
      difficultyContainer.addView(tv);
      tv.setOnClickListener(difficultyListener);
    }
  }

  private View.OnClickListener difficultyListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      TextView tv = (TextView) v;
      Toast.makeText(context, tv.getText() + " was clicked", Toast.LENGTH_SHORT).show();
    }
  };

  public String getDifficultyDescriptor(int level) {
    switch (level) {
      case Character.KNOWLEDGE_BASIC:
        return context.getResources().getString(R.string.knowledge_basic);

      case Character.KNOWLEDGE_INTERMEDIATE:
        return context.getResources().getString(R.string.knowledge_intermediate);

      case Character.KNOWLEDGE_SUPERIOR:
        return context.getResources().getString(R.string.knowledge_superior);

      case Character.KNOWLEDGE_EXPERT:
        return context.getResources().getString(R.string.knowledge_expert);
    }

    return "";
  }
}
