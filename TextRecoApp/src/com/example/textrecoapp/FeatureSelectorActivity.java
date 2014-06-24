/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

@SuppressLint("NewApi")
public class FeatureSelectorActivity extends Activity {

  private View characterBackground;
  private LinearLayout characterContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.character_layout);

    initUI();
    loadCharacters();
  }

  private View.OnClickListener characterListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
      Toast.makeText(FeatureSelectorActivity.this, String.valueOf(v.getTag()), Toast.LENGTH_SHORT).show();
    }
  };

  private void initUI() {
    characterBackground = findViewById(R.id.character_background);
    characterBackground.setBackgroundResource(R.drawable.muzei_background_main);

    characterContainer = (LinearLayout) findViewById(R.id.character_container);
  }

  private void loadCharacters() {
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    ImageView achievements = new ImageView(this);
    achievements.setTag("Achievements");
    achievements.setImageDrawable(UiUtils.getStateDrawableForId(this, "achievements"));
    achievements.setLayoutParams(params);
    achievements.setOnClickListener(characterListener);
    characterContainer.addView(achievements);

    ImageView muzei = new ImageView(this);
    muzei.setTag("Muzei");
    muzei.setImageDrawable(UiUtils.getStateDrawableForId(this, "middle"));
    muzei.setLayoutParams(params);
    muzei.setOnClickListener(characterListener);
    characterContainer.addView(muzei);

    ImageView statue = new ImageView(this);
    statue.setTag("Statue");
    statue.setImageDrawable(UiUtils.getStateDrawableForId(this, "statue"));
    statue.setLayoutParams(params);
    statue.setOnClickListener(characterListener);
    characterContainer.addView(statue);
  }


}
