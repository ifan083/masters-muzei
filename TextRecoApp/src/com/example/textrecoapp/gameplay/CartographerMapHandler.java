/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import com.example.textrecoapp.App;
import com.example.textrecoapp.R;
import com.example.textrecoapp.map.BuildingNavigator;
import com.example.textrecoapp.map.Floor;
import com.example.textrecoapp.map.FloorGenerator;
import com.example.textrecoapp.map.HelperCircle;
import com.example.textrecoapp.map.MapControllerView;
import com.example.textrecoapp.map.Pin;

public class CartographerMapHandler {

  private Context context;
  private MapControllerView mapView;
  private LinearLayout floorContainer;

  public CartographerMapHandler(Context context, ViewGroup panelView) {
    this.context = context;

    mapView = (MapControllerView) panelView.findViewById(R.id.map_view);
    BuildingNavigator navigator = App.getInstance().getCartographer().getNavigator();
    mapView.setNavigator(navigator);

    floorContainer = (LinearLayout) panelView.findViewById(R.id.floors_container);
    populateFloors();
  }

  private View.OnClickListener floorChanger = new OnClickListener() {

    @Override
    public void onClick(View v) {
      mapView.changeFloor(String.valueOf(v.getTag()));
    }
  };

  private void populateFloors() {
    LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    floorContainer.removeAllViews();
    for (Floor floor : FloorGenerator.getInstance().getFloors()) {
      Button btn = new Button(context);
      btn.setText(String.valueOf(floor.getFloorLevel()));
      btn.setTag(floor.getFloorId());
      btn.setLayoutParams(params);
      btn.setOnClickListener(floorChanger);
      floorContainer.addView(btn);
    }
  }

  public void handleUnlockingArtifact(Artifact artifact) {
    Toast.makeText(context, artifact.getName() + "is now unlocked", Toast.LENGTH_SHORT).show();

    // show dialog?
    mapView.updatePinBitmaps();
    mapView.invalidate();
    Pin preparedPin = new Pin(artifact);
    mapView.markAndCenterPin(preparedPin);
  }

  public void handleMapBrowsing() {
    mapView.markAndCenterPin(null);
    mapView.setHelperCircle(null);
    mapView.invalidate();
  }

  public void handleWrongExistingArtifactScanned(Artifact artifact) {
    Pin preparedPin = new Pin(artifact);
    mapView.markAndCenterPin(preparedPin);

    Toast.makeText(context, "The desired artifact is somewhere in the red area", Toast.LENGTH_SHORT).show();

    Artifact targetArtifact = App.getInstance().getCharacterManager().getCharacter().getMission().getArtifact();
    HelperCircle helperCircle = calculateHelperCircle(artifact, targetArtifact);
    mapView.setHelperCircle(helperCircle);
  }

  private HelperCircle calculateHelperCircle(Artifact current, Artifact target) {
    float currentX = current.getLocation().getxPercentage();
    float currentY = current.getLocation().getyPercentage();

    float targetX = target.getLocation().getxPercentage();
    float targetY = target.getLocation().getyPercentage();

    float mustRunThroughX = (currentX + targetX) / 2;
    float mustRunThroughY = (currentY + targetY) / 2;

    // TODO, what if different floor?
    float centerX = 0;
    float centerY = 0;

    if (targetX >= currentX) {
      centerX = (1.0f - targetX) / 2;
    } else {
      centerX = targetX / 2;
    }

    if (targetY >= currentY) {
      centerY = (1.0f - targetY) / 2;
    } else {
      centerY = targetY / 2;
    }

    PointF cp = new PointF(centerX, centerY);
    PointF pp = new PointF(mustRunThroughX, mustRunThroughY);

    HelperCircle hc = new HelperCircle(cp, pp);
    return hc;
  }

}
