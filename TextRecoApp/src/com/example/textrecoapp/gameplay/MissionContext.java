/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import java.util.List;

public class MissionContext {

  public static final int STAGE_FAILED = 0;
  public static final int STAGE_PASSED = 1;
  public static final int MISSION_COMPLETE = 2;

  private int difficulty;
  private String title;
  private List<MissionStage> stages;
  private int current;

  public MissionContext(String title, int difficulty, List<MissionStage> stages) {
    this.title = title;
    this.stages = stages;
    this.difficulty = difficulty;
    current = 0;
  }

  public String getTitle() {
    return title;
  }

  public List<MissionStage> getStages() {
    return stages;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public int tryAnswer(String newTry) {
    boolean isCorrect = stages.get(current).tryAnswer(newTry);

    if (!isCorrect) {
      return STAGE_FAILED;
    } else {
      if (current == stages.size() - 1) {
        return MISSION_COMPLETE;
      }

      current++;
      return STAGE_PASSED;
    }

  }

  public String getMissionProgress() {
    return current + " / " + stages.size();
  }
}
