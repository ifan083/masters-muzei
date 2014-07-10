/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gamification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.textrecoapp.achievements.Achievement;
import com.example.textrecoapp.gameplay.MissionContext;

public class AchievementChecker {

  public List<Achievement> checkAchievements(MissionContext mission) {
    List<Achievement> freshlyUnlockedAchievements = new ArrayList<Achievement>();

    for (Map.Entry<String, List<Achievement>> entry : AchievementGenerator.getInstance().getAchievements().entrySet()) {

      for (Achievement achievement : entry.getValue()) {

        //FIXME implement logic for continuous missions (comparison with entered mission and achievement criteria)
        if (achievement.isContinuous()) {
          continue;
        }

        boolean previouslyUnlocked = achievement.isUnlocked();
        achievement.checkAchievement(mission);
        if (achievement.isUnlocked() && !previouslyUnlocked) {
          freshlyUnlockedAchievements.add(achievement);
        }

      }
    }

    return freshlyUnlockedAchievements;
  }
}
