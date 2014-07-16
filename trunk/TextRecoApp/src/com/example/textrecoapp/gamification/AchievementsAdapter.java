/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gamification;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.textrecoapp.R;
import com.example.textrecoapp.achievements.Achievement;

@SuppressLint("InflateParams")
public class AchievementsAdapter extends ArrayAdapter<Object> {

  private int columnWidth;

  public AchievementsAdapter(Context context, int resource, List<Object> objects) {
    super(context, resource, objects);
  }

  public void setNumColumnsAndCalculateHeight(int numColumns) {
    DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();

    int spacing = getContext().getResources().getDimensionPixelOffset(R.dimen.column_spacing);
    int margin = getContext().getResources().getDimensionPixelOffset(R.dimen.grid_margin_horizontal);

    columnWidth = metrics.widthPixels - 2 * margin - (numColumns - 1) * spacing;
    columnWidth /= numColumns;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    Object obj = getItem(position);
    View view = convertView;

    if (view == null) {
      view = LayoutInflater.from(getContext()).inflate(R.layout.achievement, null);
    }

    TextView tv = (TextView) view.findViewById(R.id.achievement_label);
    tv.getLayoutParams().height = columnWidth;
    
    ImageView iv = (ImageView) view.findViewById(R.id.lock_img);

    if (obj instanceof Achievement) {
      Achievement a = (Achievement) obj;
      tv.setText(a.getName());
      tv.setBackgroundColor(Color.BLUE);
      view.setEnabled(true);
      tv.setTextColor(Color.WHITE);
      tv.setTypeface(null, Typeface.BOLD);

      if (a.isContinuous() && a.getTimes() > 0) {
        // unlocked
        tv.setText(tv.getText() + " x" + a.getTimes());
        iv.setVisibility(View.INVISIBLE);
      } else if (a.isUnlocked()) {
        iv.setVisibility(View.INVISIBLE);
      } else {
        iv.setVisibility(View.VISIBLE);
        tv.setTextColor(Color.GRAY);
        tv.setTypeface(null, Typeface.NORMAL);
      }


    } else {
      iv.setVisibility(View.INVISIBLE);
      tv.setText("");
      tv.setBackgroundColor(Color.GRAY);
      view.setEnabled(false);
    }

    return view;
  }
}
