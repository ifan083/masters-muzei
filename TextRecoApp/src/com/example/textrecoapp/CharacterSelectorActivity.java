/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.data.CharacterGenerator;
import com.example.textrecoapp.gameplay.CartographerMapHandler;
import com.example.textrecoapp.gameplay.CharacterMissionHandler;

public class CharacterSelectorActivity extends Activity {

  public static final int REQ_CODE_OCR = 3606;
  public static final String EXTRAS_MISSION_STATUS = "mission_status";

  private ViewGroup leftPanel;
  private ViewGroup rightPanel;
  private View characterBackground;
  private LinearLayout characterContainer;

  private int screenCenterX;
  private View selectedView;
  private int selectedViewLeft;

  private CharacterMissionHandler missionHandler;
  private CartographerMapHandler mapHandler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.panel_layout);

    initUI();
    loadCharacters();
    loadHandlers();
  }

  private void loadHandlers() {
    missionHandler = new CharacterMissionHandler(this);
  }

  private void initUI() {
    // views
    characterBackground = findViewById(R.id.character_background);
    characterBackground.setBackgroundResource(R.drawable.character_background);
    characterContainer = (LinearLayout) findViewById(R.id.character_container);

    leftPanel = (ViewGroup) findViewById(R.id.left_info_panel);
    rightPanel = (ViewGroup) findViewById(R.id.right_info_panel);

    // values
    DisplayMetrics metrics = getResources().getDisplayMetrics();
    screenCenterX = metrics.widthPixels / 2;
  }

  private View.OnClickListener characterClickListener = new OnClickListener() {

    @Override
    public void onClick(View v) {

      // stop further selecting of the same character
      if (selectedView != null) {
        return;
      }

      // fade out other views
      for (int i = 0; i < characterContainer.getChildCount(); i++) {
        final View childView = characterContainer.getChildAt(i);
        if (!v.equals(childView)) {
          AnimationUtils.fadeOutView(childView);
        }
      }

      // translate to center of screen current view
      int left = v.getLeft() + v.getWidth() / 2;
      // store settings
      selectedView = v;
      selectedViewLeft = left;

      // animate
      v.animate().translationXBy(screenCenterX - left);

      AnimationUtils.fadeInView(leftPanel);
      AnimationUtils.fadeInView(rightPanel);

      if (v.getTag().equals("Cartographer")) {
        Toast.makeText(CharacterSelectorActivity.this, "Cartographer was clicked", Toast.LENGTH_SHORT).show();
      } else {
        String characterName = String.valueOf(v.getTag());
        missionHandler.handleMissionForCharacter(characterName, leftPanel, rightPanel);
      }
    }

  };

  private void loadCharacters() {
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    ImageView cartographer = new ImageView(this);
    cartographer.setLayoutParams(params);
    cartographer.setTag("Cartographer");
    cartographer.setImageDrawable(UiUtils.getStateDrawableForId(this, "cartographer", false));
    cartographer.setOnClickListener(characterClickListener);
    characterContainer.addView(cartographer);

    for (Character character : CharacterGenerator.getInstance().getCharacters()) {
      ImageView iv = new ImageView(this);
      iv.setLayoutParams(params);
      iv.setTag(character.getName());
      iv.setImageDrawable(UiUtils.getStateDrawableForId(this, character.getPictureFilename(), false));
      iv.setOnClickListener(characterClickListener);
      characterContainer.addView(iv);
    }
  }

  private void goBackToNormal() {
    for (int i = 0; i < characterContainer.getChildCount(); i++) {
      final View childView = characterContainer.getChildAt(i);
      if (!childView.equals(selectedView)) {
        AnimationUtils.fadeInView(childView);
      }
    }

    selectedView.animate().translationXBy(selectedViewLeft - screenCenterX);
    selectedView = null;

    AnimationUtils.fadeOutView(leftPanel);
    AnimationUtils.fadeOutView(rightPanel);
  }

  @Override
  public void onBackPressed() {
    if (selectedView == null) {
      super.onBackPressed();
    } else {
      goBackToNormal();
    }
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQ_CODE_OCR && resultCode == RESULT_OK) {
      int result = data.getExtras().getInt(EXTRAS_MISSION_STATUS);
      missionHandler.handleResultFromOCR(result);
    }
  }

}
