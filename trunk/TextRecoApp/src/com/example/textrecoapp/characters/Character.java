/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.characters;

/**
 * AKA Category.
 */
public class Character {

  private String name;
  private String categoryName;
  private String pictureFilename;
  private int totalMissions;
  private int currentMission;

  public Character(String name, String categoryName, String pictureFilename, int totalMissions, int currentMission) {
    this.name = name;
    this.categoryName = categoryName;
    this.pictureFilename = pictureFilename;
    this.totalMissions = totalMissions;
    this.currentMission = currentMission;
  }

  public String getName() {
    return name;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public String getPictureFilename() {
    return pictureFilename;
  }

  public int getTotalMissions() {
    return totalMissions;
  }

  public int getCurrentMission() {
    return currentMission;
  }

  public void updateMissionStatus() {
    currentMission++;
  }

}
