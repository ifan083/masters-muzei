/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import java.util.ArrayList;
import java.util.List;
import com.example.textrecoapp.gameplay.Artifact;

import android.content.Context;
import android.util.SparseArray;

public class BuildingNavigator {

  private Context context;

  private SparseArray<StoreyState> storeys;
  private StoreyState currentStorey;

  public BuildingNavigator(Context context, List<Artifact> allArtifacts) {
    this.context = context;
    filterPinsByStorey(allArtifacts);
  }

  private void filterPinsByStorey(List<Artifact> allArtifacts) {
    storeys = new SparseArray<StoreyState>();

    SparseArray<List<Artifact>> tempStoreys = new SparseArray<List<Artifact>>();

    for (Artifact a : allArtifacts) {
      if (tempStoreys.get(a.getFloor()) == null) {
        tempStoreys.put(a.getFloor(), new ArrayList<Artifact>());
      }
      tempStoreys.get(a.getFloor()).add(a);
    }

    for (int i = 0; i < tempStoreys.size(); i++) {
      storeys.put(tempStoreys.keyAt(i), new StoreyState(null, tempStoreys.valueAt(i)));
    }

  }

  public void changeStorey(int floor) {
    currentStorey = storeys.get(floor);
  }

  public StoreyState getStoreyState() {
    return currentStorey;
  }
}
