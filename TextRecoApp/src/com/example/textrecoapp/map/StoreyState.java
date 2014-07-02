/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.example.textrecoapp.gameplay.Artifact;

public class StoreyState {

  private String storeyMapFilename;
  private List<Artifact> pins;

  public StoreyState(String storeyMapFilename, List<Artifact> pins) {
    this.storeyMapFilename = storeyMapFilename;
    this.pins = pins;
    sortByVerticalCoordinate(this.pins);
  }

  private void sortByVerticalCoordinate(List<Artifact> pins) {
    Collections.sort(pins, verticalCoordinateComparator);
  }

  private Comparator<Artifact> verticalCoordinateComparator = new Comparator<Artifact>() {

    @Override
    public int compare(Artifact lhs, Artifact rhs) {
      float lhsY = lhs.getCoordinatePercentages()[1];
      float rhsY = rhs.getCoordinatePercentages()[1];

      if (lhsY < rhsY) {
        return -1;
      } else if (lhsY > rhsY) {
        return 1;
      }
      return 0;
    }
  };

  public String getStoreyMapFilename() {
    return storeyMapFilename;
  }

  public List<Artifact> getPins() {
    return pins;
  }

}
