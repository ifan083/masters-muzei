/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.data;

import java.util.ArrayList;
import java.util.List;

import com.example.textrecoapp.gameplay.Artifact;

public class ArtifactsGenerator {

  private List<Artifact> artifacts;
  
  private static ArtifactsGenerator generatorInstance;
  
  public static ArtifactsGenerator getInstance() {
    if(generatorInstance == null) {
      generatorInstance = new ArtifactsGenerator();
    }
    return generatorInstance;
  }
  
  private ArtifactsGenerator() {
    init();
  }

  private void init() {
    
    artifacts = new ArrayList<Artifact>();
    
    // komita
    Artifact artifact = new Artifact("комита артефакт 1", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 2", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 3", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 4", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 5", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 6", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 7", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 8", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 9", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 10", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 11", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 12", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 13", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 14", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 15", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 16", "Hint1. Hint2. Hint3. Hint4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    
    // partizan
    artifact = new Artifact("партизан артефакт 1", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 2", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 3", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 4", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 5", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 6", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 7", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 8", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 9", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 10", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 11", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 12", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 13", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 14", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 15", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 16", "Hint1. Hint2. Hint3. Hint4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    
    // Ancient warrior
    artifact = new Artifact("антички воин артефакт 1", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 2", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 3", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 4", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 5", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 6", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 7", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 8", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 9", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 10", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 11", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 12", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 13", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 14", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 15", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 16", "Hint1. Hint2. Hint3. Hint4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
  }
  
  public int getTotalLevelsForCategory(String categoryName) {
    List<Integer> diffLvls = new ArrayList<Integer>();
    for (Artifact a : artifacts) {
      if (a.getCategory().equals(categoryName)) {

        if (!diffLvls.contains(Integer.valueOf(a.getDifficulty()))) {
          diffLvls.add(Integer.valueOf(a.getDifficulty()));
        }

      }
    }
    return diffLvls.size();
  }
}
