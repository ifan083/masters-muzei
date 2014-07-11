/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gamification;

import java.util.ArrayList;
import java.util.HashMap;
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
    achievements = new HashMap<String, List<Achievement>>();

    // general
    List<Achievement> generalAchievements = new ArrayList<Achievement>();
    Achievement general =
        new Achievement("First completed mission", "Complete any mission", new FirstMissionEver(), false);
    generalAchievements.add(general);
    general =
        new Achievement("Unlocked all difficulty 1 artifacts", "Find all difficulty 1 artifacts", new CheckArtifacts(1,
            null), false);
    generalAchievements.add(general);
    general =
        new Achievement("Unlocked all difficulty 2 artifacts", "Find all difficulty 1 artifacts", new CheckArtifacts(2,
            null), false);
    generalAchievements.add(general);
    general =
        new Achievement("Unlocked all difficulty 3 artifacts", "Find all difficulty 1 artifacts", new CheckArtifacts(3,
            null), false);
    generalAchievements.add(general);
    general =
        new Achievement("Unlocked all difficulty 4 artifacts", "Find all difficulty 1 artifacts", new CheckArtifacts(4,
            null), false);
    generalAchievements.add(general);
    achievements.put("General", generalAchievements);

    // komita
    List<Achievement> komitaAchievements = new ArrayList<Achievement>();
    Achievement komita =
        new Achievement("Completed Komita mission difficulty 1",
            "Number of completed Komita missions with difficulty 1", new CompletedMissionByCategoryAndDifficulty(
                "Komita", 1), true);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Unlocked all difficulty 1 Komita artifacts", "Find all dificulty 1 Komita artifacts",
            new CheckArtifacts(1, "Komita"), false);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Completed Komita mission difficulty 2",
            "Number of completed Komita missions with difficulty 2", new CompletedMissionByCategoryAndDifficulty(
                "Komita", 2), true);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Unlocked all difficulty 2 Komita artifacts", "Find all dificulty 2 Komita artifacts",
            new CheckArtifacts(2, "Komita"), false);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Completed Komita mission difficulty 3",
            "Number of completed Komita missions with difficulty 3", new CompletedMissionByCategoryAndDifficulty(
                "Komita", 3), true);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Unlocked all difficulty 3 Komita artifacts", "Find all dificulty 3 Komita artifacts",
            new CheckArtifacts(3, "Komita"), false);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Completed Komita mission difficulty 4",
            "Number of completed Komita missions with difficulty 4", new CompletedMissionByCategoryAndDifficulty(
                "Komita", 4), true);
    komitaAchievements.add(komita);
    komita =
        new Achievement("Unlocked all difficulty 4 Komita artifacts", "Find all dificulty 4 Komita artifacts",
            new CheckArtifacts(4, "Komita"), false);
    komitaAchievements.add(komita);
    achievements.put("Komita", komitaAchievements);

    // partizan
    List<Achievement> partizanAchievements = new ArrayList<Achievement>();
    Achievement partizan =
        new Achievement("Completed Partizan mission difficulty 1",
            "Number of completed Partizan missions with difficulty 1", new CompletedMissionByCategoryAndDifficulty(
                "Partizan", 1), true);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Unlocked all difficulty 1 Partizan artifacts", "Find all dificulty 1 Partizan artifacts",
            new CheckArtifacts(1, "Partizan"), false);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Completed Partizan mission difficulty 2",
            "Number of completed Partizan missions with difficulty 2", new CompletedMissionByCategoryAndDifficulty(
                "Partizan", 2), true);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Unlocked all difficulty 2 Partizan artifacts", "Find all dificulty 2 Partizan artifacts",
            new CheckArtifacts(2, "Partizan"), false);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Completed Partizan mission difficulty 3",
            "Number of completed Partizan missions with difficulty 3", new CompletedMissionByCategoryAndDifficulty(
                "Partizan", 3), true);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Unlocked all difficulty 3 Partizan artifacts", "Find all dificulty 3 Partizan artifacts",
            new CheckArtifacts(3, "Partizan"), false);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Completed Partizan mission difficulty 4",
            "Number of completed Partizan missions with difficulty 4", new CompletedMissionByCategoryAndDifficulty(
                "Partizan", 4), true);
    partizanAchievements.add(partizan);
    partizan =
        new Achievement("Unlocked all difficulty 4 Partizan artifacts", "Find all dificulty 4 Partizan artifacts",
            new CheckArtifacts(4, "Partizan"), false);
    partizanAchievements.add(partizan);
    achievements.put("Partizan", partizanAchievements);

    // ancient warrior
    List<Achievement> warriorAchievements = new ArrayList<Achievement>();
    Achievement warrior =
        new Achievement("Completed Ancient warrior mission difficulty 1",
            "Number of completed Ancient warrior with difficulty 1", new CompletedMissionByCategoryAndDifficulty(
                "Ancient warrior", 1), true);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Unlocked all difficulty 1 Ancient warrior artifacts",
            "Find all dificulty 1 Ancient warrior artifacts", new CheckArtifacts(1, "Ancient warrior"), false);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Completed Ancient warrior mission difficulty 2",
            "Number of completed Ancient warrior with difficulty 2", new CompletedMissionByCategoryAndDifficulty(
                "Ancient warrior", 2), true);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Unlocked all difficulty 2 Ancient warrior artifacts",
            "Find all dificulty 2 Ancient warrior artifacts", new CheckArtifacts(2, "Ancient warrior"), false);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Completed Ancient warrior mission difficulty 3",
            "Number of completed Ancient warrior with difficulty 3", new CompletedMissionByCategoryAndDifficulty(
                "Ancient warrior", 3), true);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Unlocked all difficulty 3 Ancient warrior artifacts",
            "Find all dificulty 3 Ancient warrior artifacts", new CheckArtifacts(3, "Ancient warrior"), false);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Completed Ancient warrior mission difficulty 4",
            "Number of completed Ancient warrior with difficulty 4", new CompletedMissionByCategoryAndDifficulty(
                "Ancient warrior", 4), true);
    warriorAchievements.add(warrior);
    warrior =
        new Achievement("Unlocked all difficulty 4 Ancient warrior artifacts",
            "Find all dificulty 4 Ancient warrior artifacts", new CheckArtifacts(4, "Ancient warrior"), false);
    warriorAchievements.add(warrior);
    achievements.put("Ancient Warrior", warriorAchievements);

  }

  public Map<String, List<Achievement>> getAchievements() {
    return achievements;
  }

}
