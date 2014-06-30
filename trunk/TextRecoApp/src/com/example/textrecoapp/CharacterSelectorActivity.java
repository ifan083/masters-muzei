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
import android.widget.TextView;

import com.example.textrecoapp.characters.Character;
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

  // panel contents
  private TextView leftTitle;
  private TextView leftContent;

  private CharacterMissionHandler missionHandler;
  private CartographerMapHandler mapHandler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.panel_layout);

    initUI();
    loadCharacters();
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

      populateLeftPanel(v);
      populateRightPanel(v);

      if (v.getTag().equals("")) {

      } else {
        String characterNameId = String.valueOf(v.getTag());
        Character character = findCharacterByName(characterNameId);
        missionHandler.handleMissionForCharacter(character, leftPanel, rightPanel);
      }
    }

  };

  private Character findCharacterByName(String characterNameId) {
    return null;
  }

  private void populateRightPanel(View view) {
    // TODO Auto-generated method stub

  }

  private void populateLeftPanel(View view) {
    String title = String.valueOf(view.getTag());
    String content =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit." + " Ut fringilla erat ac vulputate porta. "
            + "Donec vel purus in ipsum vulputate lobortis ut at leo." + " Integer sodales quis nibh ut dapibus."
            + " Aenean euismod est scelerisque, ultricies metus quis, accumsan eros. "
            + "Curabitur egestas egestas placerat." + " Aenean pulvinar, libero vel suscipit facilisis, "
            + "leo ipsum volutpat risus, " + "sit amet malesuada neque mauris vitae magna.;";
    leftTitle.setText(title);
    leftContent.setText(content);
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

    ImageView ancientWarior = new ImageView(this);
    ancientWarior.setLayoutParams(params);
    ancientWarior.setTag("Ancient warrior");
    ancientWarior.setImageDrawable(UiUtils.getStateDrawableForId(this, "falanga_man", false));
    ancientWarior.setOnClickListener(characterClickListener);
    characterContainer.addView(ancientWarior);

    ImageView komita = new ImageView(this);
    komita.setLayoutParams(params);
    komita.setTag("Komita");
    komita.setImageDrawable(UiUtils.getStateDrawableForId(this, "komita", false));
    komita.setOnClickListener(characterClickListener);
    characterContainer.addView(komita);

    ImageView partizan = new ImageView(this);
    partizan.setLayoutParams(params);
    partizan.setTag("Partizan");
    partizan.setImageDrawable(UiUtils.getStateDrawableForId(this, "partizan", false));
    partizan.setOnClickListener(characterClickListener);
    characterContainer.addView(partizan);
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
