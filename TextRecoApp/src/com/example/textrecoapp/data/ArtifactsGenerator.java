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
    Artifact artifact = new Artifact("комита артефакт 1", "Hint1 1. Hint2 1. Hint3 1. Hint4 1.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 2", "Hint1 2. Hint2 2. Hint3 2. Hint4 2.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 3", "Hint1 3. Hint2 3. Hint3 3. Hint4 3.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 4", "Hint1 4. Hint2 4. Hint3 4. Hint4 4.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 5", "Hint1 5. Hint2 5. Hint3 5. Hint4 5.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 6", "Hint1 6. Hint2 6. Hint3 6. Hint4 6.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 7", "Hint1 7. Hint2 7. Hint3 7. Hint4 7.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 8", "Hint1 8. Hint2 8. Hint3 8. Hint4 8.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 9", "Hint1 9. Hint2 9. Hint3 9. Hint4 9.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 10", "Hint1 10. Hint2 10. Hint3 10. Hint4 10.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 11", "Hint1 11. Hint2 11. Hint3 11. Hint4 11.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 12", "Hint1 12. Hint2 12. Hint3 12. Hint4 12.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 13", "Hint1 13. Hint2 13. Hint3 13. Hint4 13.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 14", "Hint1 14. Hint2 14. Hint3 14. Hint4 14.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 15", "Hint1 15. Hint2 15. Hint3 15. Hint4 15.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 16", "Hint1 16. Hint2 16. Hint3 16. Hint4 16.", "Komita", "pictureFilename", new float[] {0.23f,0.66f}, 4);
    artifacts.add(artifact);
    
    // partizan
    artifact = new Artifact("партизан артефакт 1", "Hint1 1. Hint2 1. Hint3 1. Hint4 1.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 2", "Hint1 2. Hint2 2. Hint3 2. Hint4 2.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 3", "Hint1 3. Hint2 3. Hint3 3. Hint4 3.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 4", "Hint1 4. Hint2 4. Hint3 4. Hint4 4.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 5", "Hint1 5. Hint2 5. Hint3 5. Hint4 5.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 6", "Hint1 6. Hint2 6. Hint3 6. Hint4 6.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 7", "Hint1 7. Hint2 7. Hint3 7. Hint4 7.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 8", "Hint1 8. Hint2 8. Hint3 8. Hint4 8.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 9", "Hint1 9. Hint2 9. Hint3 9. Hint4 9.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 10", "Hint1 10. Hint2 10. Hint3 10. Hint4 10.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 11", "Hint1 11. Hint2 11. Hint3 11. Hint4 11.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 12", "Hint1 12. Hint2 12. Hint3 12. Hint4 12.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 13", "Hint1 13. Hint2 13. Hint3 13. Hint4 13.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 14", "Hint1 14. Hint2 14. Hint3 14. Hint4 14.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 15", "Hint1 15. Hint2 15. Hint3 15. Hint4 15.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 16", "Hint1 16. Hint2 16. Hint3 16. Hint4 16.", "Partizan", "pictureFilename", new float[]{0.45f, 0.77f}, 4);
    artifacts.add(artifact);
    
    // Ancient warrior
    artifact = new Artifact("антички воин артефакт 1", "Hint1 1. Hint2 1. Hint3 1. Hint4 1.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 2", "Hint1 2. Hint2 2. Hint3 2. Hint4 2.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 3", "Hint1 3. Hint2 3. Hint3 3. Hint4 3.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 4", "Hint1 4. Hint2 4. Hint3 4. Hint4 4.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 5", "Hint1 5. Hint2 5. Hint3 5. Hint4 5.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 6", "Hint1 6. Hint2 6. Hint3 6. Hint4 6.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 7", "Hint1 7. Hint2 7. Hint3 7. Hint4 7.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 8", "Hint1 8. Hint2 8. Hint3 8. Hint4 8.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 9", "Hint1 9. Hint2 9. Hint3 9. Hint4 9.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 10", "Hint1 10. Hint2 10. Hint3 10. Hint4 10.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 11", "Hint1 11. Hint2 11. Hint3 11. Hint4 11.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 12", "Hint1 12. Hint2 12. Hint3 12. Hint4 12.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 13", "Hint1 13. Hint2 13. Hint3 13. Hint4 13.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 14", "Hint1 14. Hint2 14. Hint3 14. Hint4 14.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 15", "Hint1 15. Hint2 15. Hint3 15. Hint4 15.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 16", "Hint1 16. Hint2 16. Hint3 16. Hint4 16.", "Ancient warrior", "pictureFilename", new float[] {0.86f, 0.33f}, 4);
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
  
  public List<Artifact> getAllArtifacts() {
    return artifacts;
  }
}
