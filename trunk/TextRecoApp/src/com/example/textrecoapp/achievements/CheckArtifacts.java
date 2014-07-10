/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.achievements;

import com.example.textrecoapp.App;
import com.example.textrecoapp.data.ArtifactsGenerator;
import com.example.textrecoapp.gameplay.Artifact;
import com.example.textrecoapp.gameplay.MissionContext;
import com.example.textrecoapp.gamification.AchievementCriteria;

public class CheckArtifacts implements AchievementCriteria {

  private int difficulty;
  private String category;

  public CheckArtifacts(int difficulty, String category) {
    this.difficulty = difficulty;
    this.category = category;
  }

  @Override
  public boolean checkAchievement(MissionContext mission) {

    if (category == null) {
      return checkArtifactsByRank();
    }

    int totalRequestedArtifacts =
        ArtifactsGenerator.getInstance().getTotalArtifactsForCategoryAndDifficulty(category, difficulty);

    int counter = 0;
    for (Artifact a : App.getInstance().getCartographer().getArtifacts()) {
      if (a.getCategory().equals(category) && a.getDifficulty() == difficulty && a.isArtefactUnlocked()) {
        counter++;
      }
    }

    return counter == totalRequestedArtifacts;
  }

  private boolean checkArtifactsByRank() {
    int totalArtifacts = ArtifactsGenerator.getInstance().getAllArtifacts().size();

    int counter = 0;
    for (Artifact a : App.getInstance().getCartographer().getArtifacts()) {
      if (a.getDifficulty() == difficulty) {
        counter++;
      }
    }
    return counter == totalArtifacts;
  }

}
