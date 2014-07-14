/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gamification;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.textrecoapp.achievements.Achievement;
import com.example.textrecoapp.achievements.CheckArtifacts;
import com.example.textrecoapp.achievements.CompletedMissionByCategoryAndDifficulty;
import com.example.textrecoapp.achievements.FirstMissionEver;

public class AchievementGenerator {

  private Map<String, List<Achievement>> achievements;

  public AchievementGenerator() {
    init();
  }

  private void init() {
    achievements = new LinkedHashMap<String, List<Achievement>>();

    // general
    List<Achievement> generalAchievements = new ArrayList<Achievement>();

    AchievementCriteria generalCriteria = new FirstMissionEver();
    Achievement general = new Achievement("First completed mission", "Complete any mission", generalCriteria, false);
    generalAchievements.add(general);

    AchievementCriteria generalCriteria1 = new CheckArtifacts(1, null);
    general = new Achievement("Unlocked all difficulty 1 artifacts", "Find all difficulty 1 artifacts",
        generalCriteria1, false);
    generalAchievements.add(general);

    AchievementCriteria generalCriteria2 = new CheckArtifacts(2, null);
    general = new Achievement("Unlocked all difficulty 2 artifacts", "Find all difficulty 1 artifacts",
        generalCriteria2, false);

    AchievementCriteria generalCriteria3 = new CheckArtifacts(3, null);
    generalAchievements.add(general);
    general = new Achievement("Unlocked all difficulty 3 artifacts", "Find all difficulty 1 artifacts",
        generalCriteria3, false);
    generalAchievements.add(general);

    AchievementCriteria generalCriteria4 = new CheckArtifacts(4, null);
    general = new Achievement("Unlocked all difficulty 4 artifacts", "Find all difficulty 1 artifacts",
        generalCriteria4, false);
    generalAchievements.add(general);
    achievements.put("General", generalAchievements);

    // komita
    List<Achievement> komitaAchievements = new ArrayList<Achievement>();

    AchievementCriteria komitaCriteria = new CompletedMissionByCategoryAndDifficulty("Komita", 1);
    Achievement komita = new Achievement("Completed Komita mission difficulty 1",
        "Number of completed Komita missions with difficulty 1", komitaCriteria, true);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria1 = new CheckArtifacts(1, "Komita");
    komita = new Achievement("Unlocked all difficulty 1 Komita artifacts", "Find all dificulty 1 Komita artifacts",
        komitaCriteria1, false);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria2 = new CompletedMissionByCategoryAndDifficulty("Komita", 2);
    komita = new Achievement("Completed Komita mission difficulty 2",
        "Number of completed Komita missions with difficulty 2", komitaCriteria2, true);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria3 = new CheckArtifacts(2, "Komita");
    komita = new Achievement("Unlocked all difficulty 2 Komita artifacts", "Find all dificulty 2 Komita artifacts",
        komitaCriteria3, false);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria4 = new CompletedMissionByCategoryAndDifficulty("Komita", 3);
    komita = new Achievement("Completed Komita mission difficulty 3",
        "Number of completed Komita missions with difficulty 3", komitaCriteria4, true);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria5 = new CheckArtifacts(3, "Komita");
    komita = new Achievement("Unlocked all difficulty 3 Komita artifacts", "Find all dificulty 3 Komita artifacts",
        komitaCriteria5, false);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria6 = new CompletedMissionByCategoryAndDifficulty("Komita", 4);
    komita = new Achievement("Completed Komita mission difficulty 4",
        "Number of completed Komita missions with difficulty 4", komitaCriteria6, true);
    komitaAchievements.add(komita);

    AchievementCriteria komitaCriteria7 = new CheckArtifacts(4, "Komita");
    komita = new Achievement("Unlocked all difficulty 4 Komita artifacts", "Find all dificulty 4 Komita artifacts",
        komitaCriteria7, false);
    komitaAchievements.add(komita);
    achievements.put("Komita", komitaAchievements);

    // partizan
    List<Achievement> partizanAchievements = new ArrayList<Achievement>();
    AchievementCriteria partizanCriteria = new CompletedMissionByCategoryAndDifficulty("Partizan", 1);
    Achievement partizan = new Achievement("Completed Partizan mission difficulty 1",
        "Number of completed Partizan missions with difficulty 1", partizanCriteria, true);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria1 = new CheckArtifacts(1, "Partizan");
    partizan = new Achievement("Unlocked all difficulty 1 Partizan artifacts",
        "Find all dificulty 1 Partizan artifacts", partizanCriteria1, false);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria2 = new CompletedMissionByCategoryAndDifficulty("Partizan", 2);
    partizan = new Achievement("Completed Partizan mission difficulty 2",
        "Number of completed Partizan missions with difficulty 2", partizanCriteria2, true);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria3 = new CheckArtifacts(2, "Partizan");
    partizan = new Achievement("Unlocked all difficulty 2 Partizan artifacts",
        "Find all dificulty 2 Partizan artifacts", partizanCriteria3, false);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria4 = new CompletedMissionByCategoryAndDifficulty("Partizan", 3);
    partizan = new Achievement("Completed Partizan mission difficulty 3",
        "Number of completed Partizan missions with difficulty 3", partizanCriteria4, true);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria5 = new CheckArtifacts(3, "Partizan");
    partizan = new Achievement("Unlocked all difficulty 3 Partizan artifacts",
        "Find all dificulty 3 Partizan artifacts", partizanCriteria5, false);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria6 = new CompletedMissionByCategoryAndDifficulty("Partizan", 4);
    partizan = new Achievement("Completed Partizan mission difficulty 4",
        "Number of completed Partizan missions with difficulty 4", partizanCriteria6, true);
    partizanAchievements.add(partizan);

    AchievementCriteria partizanCriteria7 = new CheckArtifacts(4, "Partizan");
    partizan = new Achievement("Unlocked all difficulty 4 Partizan artifacts",
        "Find all dificulty 4 Partizan artifacts", partizanCriteria7, false);
    partizanAchievements.add(partizan);
    achievements.put("Partizan", partizanAchievements);

    // ancient warrior
    List<Achievement> warriorAchievements = new ArrayList<Achievement>();
    AchievementCriteria warriorCriteria = new CompletedMissionByCategoryAndDifficulty("Ancient warrior", 1);
    Achievement warrior = new Achievement("Completed Ancient warrior mission difficulty 1",
        "Number of completed Ancient warrior with difficulty 1", warriorCriteria, true);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria1 = new CheckArtifacts(1, "Ancient warrior");
    warrior = new Achievement("Unlocked all difficulty 1 Ancient warrior artifacts",
        "Find all difficulty 1 Ancient warrior artifacts", warriorCriteria1, false);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria2 = new CompletedMissionByCategoryAndDifficulty("Ancient warrior", 2);
    warrior = new Achievement("Completed Ancient warrior mission difficulty 2",
        "Number of completed Ancient warrior with difficulty 2", warriorCriteria2, true);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria3 = new CheckArtifacts(2, "Ancient warrior");
    warrior = new Achievement("Unlocked all difficulty 2 Ancient warrior artifacts",
        "Find all difficulty 2 Ancient warrior artifacts", warriorCriteria3, false);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria4 = new CompletedMissionByCategoryAndDifficulty("Ancient warrior", 3);
    warrior = new Achievement("Completed Ancient warrior mission difficulty 3",
        "Number of completed Ancient warrior with difficulty 3", warriorCriteria4, true);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria5 = new CheckArtifacts(3, "Ancient warrior");
    warrior = new Achievement("Unlocked all difficulty 3 Ancient warrior artifacts",
        "Find all difficulty 3 Ancient warrior artifacts", warriorCriteria5, false);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria6 = new CompletedMissionByCategoryAndDifficulty("Ancient warrior", 4);
    warrior = new Achievement("Completed Ancient warrior mission difficulty 4",
        "Number of completed Ancient warrior with difficulty 4", warriorCriteria6, true);
    warriorAchievements.add(warrior);

    AchievementCriteria warriorCriteria7 = new CheckArtifacts(4, "Ancient warrior");
    warrior = new Achievement("Unlocked all difficulty 4 Ancient warrior artifacts",
        "Find all difficulty 4 Ancient warrior artifacts", warriorCriteria7, false);
    warriorAchievements.add(warrior);
    achievements.put("Ancient Warrior", warriorAchievements);

  }

  public Map<String, List<Achievement>> getAchievements() {
    return achievements;
  }

}
