/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.characters;

import java.io.Serializable;

import com.example.textrecoapp.gameplay.MissionContext;

/**
 * AKA Category.
 */
public class Character implements Serializable {

  public static final boolean STATE_IN_PROGRESS = true;
  public static final boolean STATE_IDLE = false;
  
  public static final int KNOWLEDGE_BASIC = 1;
  public static final int KNOWLEDGE_INTERMEDIATE = 2;
  public static final int KNOWLEDGE_SUPERIOR = 3;
  public static final int KNOWLEDGE_EXPERT = 4;

  private MissionContext mission;
  private String name;
  private String category;
  private String pictureFilename;
  private int latestUnlockedLevel;
  private boolean state;

  public Character(String name, String category, String pictureFilename) {

    this.name = name;
    this.category = category;
    this.pictureFilename = pictureFilename;

    state = STATE_IDLE;
    latestUnlockedLevel = 1;
  }

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public String getPictureFilename() {
    return pictureFilename;
  }

  public boolean getState() {
    return state;
  }

  public void changeState(boolean state) {
    this.state = state;
  }

  public int getLatestUnlockedLevel() {
    return latestUnlockedLevel;
  }

  public MissionContext getMission() {
    return mission;
  }

  public void setMission(MissionContext mission) {
    this.mission = mission;
  }

}
