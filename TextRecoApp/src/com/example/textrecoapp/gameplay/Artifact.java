/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import java.io.Serializable;

public class Artifact implements Serializable {

  private String name;
  private String description;
  private String pictureFilename;
  private float[] coordinatePercentages;
  private int difficulty; // rank
  private String category;
  private boolean unlockedArtifact;
  private int floor;

  public Artifact(String name,
      String description,
      String category,
      String pictureFilename,
      float[] coordinatePercentages,
      int floor,
      int difficulty) {
    this.name = name;
    this.description = description;
    this.category = category;
    this.pictureFilename = pictureFilename;
    this.coordinatePercentages = coordinatePercentages;
    this.floor = floor;
    this.difficulty = difficulty;
  }

  public String getName() {
    return name;
  }

  public String getPictureFilename() {
    return pictureFilename;
  }

  public float[] getCoordinatePercentages() {
    return coordinatePercentages;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public String getDescription() {
    return description;
  }

  public String getCategory() {
    return category;
  }

  public void unlockArtefact() {
    unlockedArtifact = true;
  }

  public boolean isArtefactUnlocked() {
    return unlockedArtifact;
  }
  
  public int getFloor() {
    return floor;
  }

}
