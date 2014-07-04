/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.textrecoapp.gameplay.Artifact;

public class BuildingNavigator {

  private Map<String, StoreyState> storeys;
  private StoreyState currentStorey;

  public BuildingNavigator(List<Floor> floors, List<Artifact> artifacts) {
    filterPinsByStorey(floors, artifacts);
    //set the first one as default
    changeStorey(floors.get(0).getFloorId());
  }

  private void filterPinsByStorey(List<Floor> floors, List<Artifact> artifacts) {
    storeys = new HashMap<String, StoreyState>();
    for (Floor f : floors) {
      StoreyState storey = new StoreyState(f.getPictureFilename());
      storeys.put(f.getFloorId(), storey);
    }
    for (Artifact a : artifacts) {
      storeys.get(a.getFloorId()).getPins().add(new Pin(a));
    }
    for (Floor f : floors) {
      storeys.get(f.getFloorId()).sortByVerticalCoordinate();
    }
  }

  public void changeStorey(String floorId) {
    currentStorey = storeys.get(floorId);
  }

  public StoreyState getStoreyState() {
    return currentStorey;
  }
}
