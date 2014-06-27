/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

public class Artifact {

  private String name;
  private String description;
  private String pictureFilename;
  private float[] coordinatePercentages;
  private int difficulty;

  public Artifact(String name, String description, String pictureFilename, float[] coordinatePercentages, int difficulty) {
    this.name = name;
    this.description = description;
    this.pictureFilename = pictureFilename;
    this.coordinatePercentages = coordinatePercentages;
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

}
