/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gamification;

import java.util.List;

import com.example.textrecoapp.R;
import com.example.textrecoapp.achievements.Achievement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AchievementsAdapter extends ArrayAdapter<Object> {

  private LayoutInflater inflater;

  public AchievementsAdapter(Context context, int resource, List<Object> objects) {
    super(context, resource, objects);
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    Object obj = getItem(position);
    View view = null;

    if (obj instanceof Achievement) {
      view = inflater.inflate(R.layout.achievement, null);
      Achievement a = (Achievement) obj;

      TextView tv = (TextView) view.findViewById(R.id.achievement_title);
      tv.setText(a.getName());
    } else {
      view = inflater.inflate(R.layout.empty_achievement, null);
    }

    return view;
  }
}
