/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.data.CharacterGenerator;
import com.example.textrecoapp.gameplay.CartographerMapHandler;
import com.example.textrecoapp.gameplay.CharacterMissionHandler;

public class CharacterSelectorActivity extends Activity {

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
          fadeOutView(childView);
        }
      }

      // translate to center of screen current view
      int left = v.getLeft() + v.getWidth() / 2;
      // store settings
      selectedView = v;
      selectedViewLeft = left;

      // animate
      v.animate().translationXBy(screenCenterX - left);

      fadeInView(leftPanel);
      fadeInView(rightPanel);

      if (v.getTag().equals("")) {

      } else {
        String characterNameId = String.valueOf(v.getTag());
        Character character = findCharacterByName(characterNameId);
        missionHandler.handleMissionForCharacter(character, leftPanel, rightPanel);
      }
    }

  };

  private Character findCharacterByName(String characterNameId) {
    Character character = null;
    for (Character c : CharacterGenerator.getInstance().getCharacters()) {
      if (characterNameId.equals(c.getName())) {
        character = c;
        break;
      }
    }
    return character;
  }

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
        fadeInView(childView);
      }
    }

    selectedView.animate().translationXBy(selectedViewLeft - screenCenterX);
    selectedView = null;

    fadeOutView(leftPanel);
    fadeOutView(rightPanel);
  }

  private void fadeInView(View view) {
    view.setAlpha(0f);
    view.setVisibility(View.VISIBLE);
    view.animate().alpha(1f);
  }

  private void fadeOutView(final View view) {
    view.animate().alpha(0f).setListener(new AnimatorListenerAdapter() {

      public void onAnimationEnd(Animator animation) {
        view.setVisibility(View.INVISIBLE);
        view.setAlpha(1f);
        view.animate().setListener(null);
      }
    });
  }

  @Override
  public void onBackPressed() {
    if (selectedView == null) {
      super.onBackPressed();
    } else {
      goBackToNormal();
    }
  }

}
