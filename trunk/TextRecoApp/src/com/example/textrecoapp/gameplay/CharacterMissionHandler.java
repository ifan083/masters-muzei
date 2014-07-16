/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.textrecoapp.App;
import com.example.textrecoapp.CharacterSelectorActivity;
import com.example.textrecoapp.OCRActivity;
import com.example.textrecoapp.R;
import com.example.textrecoapp.UiUtils;
import com.example.textrecoapp.achievements.Achievement;
import com.example.textrecoapp.achievements.AchievementsActivity;
import com.example.textrecoapp.characters.Character;

public class CharacterMissionHandler {

  private Context context;
  private LayoutInflater layoutInflater;

  private int lockedDifficultyColor;
  private int currentDifficultyColor;
  private int unlockedDifficultyColor;
  private int unselectedDificultyColor;
  private int selectedDificultyColor;

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

  private int userSelectedDifficulty;

  public CharacterMissionHandler(Context context) {
    this.context = context;
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    lockedDifficultyColor = android.R.color.darker_gray;
    currentDifficultyColor = android.R.color.holo_green_dark;
    unlockedDifficultyColor = android.R.color.holo_blue_dark;
    selectedDificultyColor = android.R.color.holo_red_dark;
    unselectedDificultyColor = android.R.color.transparent;
  }

  public void handleMissionForCharacter(String characterName, ViewGroup leftPanel, ViewGroup rightPanel) {
    App.getInstance().getCharacterManager().changeCharacter(characterName);
    userSelectedDifficulty = -1;

    // inflate layouts
    inflateLeftPanel(leftPanel);
    inflateRightPanel(rightPanel);

    updatePanels();

    startNewMissionBtn.setOnClickListener(startNewMissionListener);
    findArtifactBtn.setOnClickListener(findArtefactListener);
  }

  private View.OnClickListener startNewMissionListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Character character = App.getInstance().getCharacterManager().getCharacter();
      if (character.getMission() == null) {
        // generate mission

        if (userSelectedDifficulty == -1) {
          Toast.makeText(context, context.getString(R.string.select_dificulty), Toast.LENGTH_SHORT).show();
          return;
        }

        missionGenerator.run();
        updatePanels();
      } else {

        String title = context.getString(R.string.dialog_mission_title);
        String message = context.getString(R.string.dialog_mission_message);
        String posBtnText = context.getString(R.string.start_new_mission);
        String negBtnText = context.getString(R.string.cancel);

        DialogInterface.OnClickListener posListener = new DialogInterface.OnClickListener() {

          @Override
          public void onClick(DialogInterface dialog, int which) {
            missionGenerator.run();
          }
        };

        UiUtils.createSimpleDialog(context, title, message, posBtnText, negBtnText, posListener,
            UiUtils.getNegListener()).show();

      }
    }
  };

  private Runnable missionGenerator = new Runnable() {

    @Override
    public void run() {
      Character character = App.getInstance().getCharacterManager().getCharacter();
      MissionContext mission = MissionGenerator.getInstance().generateMissionForCharacter(context,
          character.getCategory(), userSelectedDifficulty);
      character.setMission(mission);
    }
  };

  private void updatePanels() {
    Character character = App.getInstance().getCharacterManager().getCharacter();

    // populate always known data
    characterTitle.setText(character.getName());
    String templateString = context.getResources().getString(R.string.character_description_template);
    String charDescription = String.format(templateString, character.getCategory());
    characterDescription.setText(charDescription);

    populateDifficultyLevels(character.getCategory(), character.getLatestUnlockedLevel());

    // check idle vs. current mission behavior
    if (character.getMission() == null) {
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
  }

  private String formatMissionDescription(int difficulty) {
    Character character = App.getInstance().getCharacterManager().getCharacter();
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

  @SuppressLint("InflateParams")
  private void populateDifficultyLevels(String category, int latestUnlocked) {

    difficultyContainer.removeAllViews();

    int totalLvls = App.getInstance().getCartographer().getTotalLevelsForCategory(category);

    for (int i = 1; i <= totalLvls; i++) {
      View diffLayout = layoutInflater.inflate(R.layout.difficulty_level, null);
      diffLayout.setBackgroundResource(unselectedDificultyColor);
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
      for (int i = 0; i < difficultyContainer.getChildCount(); i++) {
        View view = difficultyContainer.getChildAt(i);
        view.setBackgroundResource(unselectedDificultyColor);
      }
      TextView tv = (TextView) v;
      userSelectedDifficulty = Integer.parseInt(String.valueOf(tv.getText()));
      FrameLayout fl = (FrameLayout) tv.getParent();
      fl.setBackgroundResource(selectedDificultyColor);
    }
  };

  public void handleResultFromOCR(int result) {
    Character character = App.getInstance().getCharacterManager().getCharacter();
    switch (result) {
      case MissionContext.STAGE_PASSED:
        Toast.makeText(context, context.getString(R.string.mission_stage_passed), Toast.LENGTH_SHORT).show();
        break;

      case MissionContext.STAGE_FAILED:
        // do nothing
        Toast.makeText(context, context.getString(R.string.mission_stage_failed), Toast.LENGTH_SHORT).show();
        break;

      case MissionContext.MISSION_COMPLETE:
        Toast.makeText(context, context.getString(R.string.mission_finished), Toast.LENGTH_SHORT).show();

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
    CharSequence[] achievements = new CharSequence[unlockedAchievements.size()];
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

    UiUtils.createDialogWithList(context, title, achievements, posBtnText, negBtnText, positiveListener,
        UiUtils.getNegListener()).show();;
  }

}
