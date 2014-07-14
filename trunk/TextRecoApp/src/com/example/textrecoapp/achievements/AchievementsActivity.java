/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.achievements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.example.textrecoapp.App;
import com.example.textrecoapp.R;
import com.example.textrecoapp.gamification.AchievementsAdapter;

public class AchievementsActivity extends Activity {

  private Map<String, List<Achievement>> achievements;
  private GridView gridView;
  private LinearLayout headersContainer;
  private AchievementsAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.achievements_grid);

    headersContainer = (LinearLayout) findViewById(R.id.headers_container);
    gridView = (GridView) findViewById(R.id.grid_view);

    achievements = App.getInstance().getAchievements();
    int numColumns = achievements.size();
    loadHeaders(achievements.keySet());
    gridView.setNumColumns(numColumns);
    loadAchievements(achievements.values());
    adapter.setNumColumnsAndCalculateHeight(numColumns);

    gridView.setOnItemClickListener(gridListener);

    // FIXME: make implementation for unlocked / locked achievements
  }

  private OnItemClickListener gridListener = new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Object obj = parent.getItemAtPosition(position);
      if (obj instanceof Achievement) {
        Achievement a = (Achievement) obj;
        Toast.makeText(AchievementsActivity.this, a.getDescription(), Toast.LENGTH_SHORT).show();
      }
    }
  };

  @SuppressLint("InflateParams")
  private void loadHeaders(Set<String> headers) {
    int headersNum = headers.size();
    int margin = getResources().getDimensionPixelOffset(R.dimen.grid_margin_horizontal);
    int rightMargin = getResources().getDimensionPixelOffset(R.dimen.column_spacing);
    DisplayMetrics metrics = getResources().getDisplayMetrics();

    int headerWidth = ((metrics.widthPixels - 2 * margin) - (headersNum - 1) * rightMargin) / headersNum;

    int counter = 0;

    headersContainer.removeAllViews();

    for (String title : headers) {

      View gridHeader = getLayoutInflater().inflate(R.layout.grid_header_layout, null);
      TextView tv = (TextView) gridHeader.findViewById(R.id.grid_title);
      tv.setText(title);

      LayoutParams params = new LayoutParams(headerWidth, LayoutParams.WRAP_CONTENT);
      if (counter != headersNum - 1) {
        params.rightMargin = rightMargin;
      }
      gridHeader.setLayoutParams(params);

      headersContainer.addView(gridHeader);

      counter++;
    }
  }

  private void loadAchievements(Collection<List<Achievement>> collection) {
    List<Object> objects = new ArrayList<Object>();
    int lonegstListSize = getLongestListSize(collection);

    for (int i = 0; i < lonegstListSize; i++) {
      for (List<Achievement> list : collection) {
        try {
          objects.add(list.get(i));
        } catch (IndexOutOfBoundsException e) {
          objects.add(new Object());
        }
      }
    }

    adapter = new AchievementsAdapter(this, 0, objects);
    gridView.setAdapter(adapter);
  }

  private int getLongestListSize(Collection<List<Achievement>> collection) {
    int longest = 0;
    for (List<Achievement> list : collection) {
      longest = list.size() > longest ? list.size() : longest;
    }
    return longest;
  }
}
