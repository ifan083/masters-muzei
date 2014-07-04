/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import com.example.textrecoapp.App;
import com.example.textrecoapp.R;

import android.app.Activity;
import android.os.Bundle;

public class MapActivity extends Activity {

  private MapControllerView mapView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);

    mapView = (MapControllerView) findViewById(R.id.map_view);

    BuildingNavigator navigator = App.getInstance().getCartographer().getNavigator();
    mapView.setNavigator(navigator);
  }
}
