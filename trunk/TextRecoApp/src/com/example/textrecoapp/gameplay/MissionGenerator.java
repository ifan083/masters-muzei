/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;

import com.example.textrecoapp.App;

public final class MissionGenerator {

  private static MissionGenerator instance;
  private Random randomGenerator;

  public static MissionGenerator getInstance() {
    if (instance == null) {
      instance = new MissionGenerator();
    }
    return instance;
  }

  private MissionGenerator() {
    init();
  }

  private void init() {
    randomGenerator = new Random();
  }

  /**
   * Generates unique mission.
   * 
   * @param category == characterName
   * @param difficulty
   * @return newly generated mission based on the input variables
   */
  public MissionContext generateMissionForCharacter(Context context, String category, int difficulty) {
    // always get 3 artifacts for each mission
    List<Artifact> artifactsForMission = new ArrayList<Artifact>();
    for (Artifact a : App.getInstance().getCartographer().getAllArtifacts()) {
      if (a.getCategory().equals(category) && a.getDifficulty() == difficulty) {
        artifactsForMission.add(a);
      }
    }

    List<MissionStage> missionStages = new ArrayList<MissionStage>();
    
    for (int i = 0; i < 3; i++) {
      Artifact artifact = artifactsForMission.get(randomGenerator.nextInt(artifactsForMission.size()));
      artifactsForMission.remove(artifact);
      
      MissionStage stage = new MissionStage(artifact);
      missionStages.add(stage);
    }
    
    String missionTitle = category + " " + GameplayUtils.getDifficultyDescriptor(context, difficulty);
    MissionContext missionContext = new MissionContext(missionTitle, difficulty, missionStages);
    return missionContext;
  }
}
