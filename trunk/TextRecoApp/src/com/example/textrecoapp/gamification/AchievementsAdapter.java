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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

    TextView tv = (TextView) view.findViewById(R.id.achievement_title);
    tv.getLayoutParams().height = columnWidth;

    if (obj instanceof Achievement) {
      Achievement a = (Achievement) obj;
      tv.setText(a.getName());
      tv.setTextColor(Color.WHITE);
      tv.setBackgroundColor(Color.BLUE);
    } else {
      tv.setText("/");
      tv.setTextColor(Color.BLACK);
      tv.setBackgroundColor(Color.GRAY);
    }

    return view;
  }
}
