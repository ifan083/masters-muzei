/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp;

import com.example.textrecoapp.ar.TrainSetHandler;
import com.example.textrecoapp.characters.CharacterManager;
import com.example.textrecoapp.data.CharacterGenerator;
import com.googlecode.tesseract.android.TessBaseAPI;

import android.app.Application;

public class App extends Application {

  private static App instance;
  private TessBaseAPI ocrAPI;
  private CharacterManager characterManager;

  public static App getInstance() {
    return instance;
  }

  public App() {
    instance = this;
    TrainSetHandler tsh = new TrainSetHandler(this, "mkd");
    tsh.initDirectory();

    new Runnable() {

      @Override
      public void run() {
        ocrAPI = new TessBaseAPI();
        ocrAPI.init(TrainSetHandler.DATA_PATH, "mkd");
      }
    }.run();;
    
    characterManager = new CharacterManager(CharacterGenerator.getInstance().getCharacters());
  }

  public TessBaseAPI getOCR_API() {
    return ocrAPI;
  }
  
  public CharacterManager getCharacterManager() {
    return characterManager;
  }
}
