/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp;

import java.util.List;
import java.util.Map;

import android.app.Application;

import com.example.textrecoapp.achievements.Achievement;
import com.example.textrecoapp.ar.TrainSetHandler;
import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.characters.CharacterManager;
import com.example.textrecoapp.data.ArtifactsGenerator;
import com.example.textrecoapp.data.CharacterGenerator;
import com.example.textrecoapp.gameplay.Artifact;
import com.example.textrecoapp.gamification.AchievementChecker;
import com.example.textrecoapp.gamification.AchievementGenerator;
import com.example.textrecoapp.map.Cartographer;
import com.example.textrecoapp.map.Floor;
import com.example.textrecoapp.map.FloorGenerator;
import com.example.textrecoapp.persistence.GSONPersister;
import com.googlecode.tesseract.android.TessBaseAPI;

public class App extends Application {

  private static App instance;
  private TessBaseAPI ocrAPI;
  private CharacterManager characterManager;
  private Cartographer cartographer;
  private GSONPersister persister;
  private AchievementChecker achievementChecker;
  private Map<String, List<Achievement>> achievements;

  public static final String LANG = "mkd";

  public static App getInstance() {
    return instance;
  }

  public App() {
    instance = this;
    TrainSetHandler tsh = new TrainSetHandler(this, LANG);
    tsh.initDirectory();

    new Runnable() {

      @Override
      public void run() {
        ocrAPI = new TessBaseAPI();
        ocrAPI.init(TrainSetHandler.DATA_PATH, LANG);
      }
    }.run();;

    persister = new GSONPersister();

    initApp();
  }

  private void initApp() {
    // characters
    List<Character> characters = persister.getStoredCharacters();
    if (characters == null) {
      CharacterGenerator characterGenerator = new CharacterGenerator();
      characters = characterGenerator.getCharacters();
    }
    characterManager = new CharacterManager(characters);

    // artifacts
    List<Floor> floors = FloorGenerator.getInstance().getFloors();
    List<Artifact> artifacts = persister.getStoredArtifacts();
    if (artifacts == null) {
      ArtifactsGenerator artifactsGenerator = new ArtifactsGenerator();
      artifacts = artifactsGenerator.getArtifacts();
    }
    cartographer = new Cartographer(floors, artifacts);

    achievements = persister.getStoredAchievements();
    if (achievements == null) {
      AchievementGenerator achievementGenerator = new AchievementGenerator();
      achievements = achievementGenerator.getAchievements();
    }
  }

  public TessBaseAPI getOCR_API() {
    return ocrAPI;
  }

  public CharacterManager getCharacterManager() {
    return characterManager;
  }

  public Cartographer getCartographer() {
    return cartographer;
  }

  public GSONPersister getPersister() {
    return persister;
  }

  public AchievementChecker getAchievementChecker() {
    return achievementChecker;
  }

  public Map<String, List<Achievement>> getAchievements() {
    return achievements;
  }

}
