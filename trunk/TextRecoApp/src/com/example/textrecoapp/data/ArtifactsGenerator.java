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
import com.example.textrecoapp.map.Location;

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
    Artifact artifact = new Artifact("комита артефакт 1", "Hint1 1. Hint2 1. Hint3 1. Hint4 1.", "The Ilinden Uprising", "pictureFilename", new Location(0.23286f, 0.11071f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 2", "Hint1 2. Hint2 2. Hint3 2. Hint4 2.", "The Ilinden Uprising", "pictureFilename", new Location(0.30143f, 0.14441f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 3", "Hint1 3. Hint2 3. Hint3 3. Hint4 3.", "The Ilinden Uprising", "pictureFilename", new Location(0.34858f, 0.14441f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 4", "Hint1 4. Hint2 4. Hint3 4. Hint4 4.", "The Ilinden Uprising", "pictureFilename", new Location(0.41429f, 0.11433f, "01_surface"), 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 5", "Hint1 5. Hint2 5. Hint3 5. Hint4 5.", "The Ilinden Uprising", "pictureFilename", new Location(0.10715f, 0.1757f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 6", "Hint1 6. Hint2 6. Hint3 6. Hint4 6.", "The Ilinden Uprising", "pictureFilename", new Location(0.18858f, 0.36703f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 7", "Hint1 7. Hint2 7. Hint3 7. Hint4 7.", "The Ilinden Uprising", "pictureFilename", new Location(0.27429f, 0.41156f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 8", "Hint1 8. Hint2 8. Hint3 8. Hint4 8.", "The Ilinden Uprising", "pictureFilename", new Location(0.25429f, 0.2828f, "01_surface"), 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 9", "Hint1 9. Hint2 9. Hint3 9. Hint4 9.", "The Ilinden Uprising", "pictureFilename", new Location(0.1362f, 0.15321f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 10", "Hint1 10. Hint2 10. Hint3 10. Hint4 10.", "The Ilinden Uprising", "pictureFilename", new Location(0.2405f, 0.15084f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 11", "Hint1 11. Hint2 11. Hint3 11. Hint4 11.", "The Ilinden Uprising", "pictureFilename", new Location(0.34847f, 0.14015f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 12", "Hint1 12. Hint2 12. Hint3 12. Hint4 12.", "The Ilinden Uprising", "pictureFilename", new Location(0.48712f, 0.15321f, "02_second"), 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("комита артефакт 13", "Hint1 13. Hint2 13. Hint3 13. Hint4 13.", "The Ilinden Uprising", "pictureFilename", new Location(0.23804f, 0.33492f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 14", "Hint1 14. Hint2 14. Hint3 14. Hint4 14.", "The Ilinden Uprising", "pictureFilename", new Location(0.25767f, 0.45962f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 15", "Hint1 15. Hint2 15. Hint3 15. Hint4 15.", "The Ilinden Uprising", "pictureFilename", new Location(0.25154f, 0.5582f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("комита артефакт 16", "Hint1 16. Hint2 16. Hint3 16. Hint4 16.", "The Ilinden Uprising", "pictureFilename", new Location(0.26749f, 0.63658f, "02_second"), 4);
    artifacts.add(artifact);
    
    // partizan
    artifact = new Artifact("партизан артефакт 1", "Hint1 1. Hint2 1. Hint3 1. Hint4 1.", "World wars", "pictureFilename", new Location(0.64286f, 0.13238f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 2", "Hint1 2. Hint2 2. Hint3 2. Hint4 2.", "World wars", "pictureFilename", new Location(0.77143f, 0.15404f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 3", "Hint1 3. Hint2 3. Hint3 3. Hint4 3.", "World wars", "pictureFilename", new Location(0.64286f, 0.19375f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 4", "Hint1 4. Hint2 4. Hint3 4. Hint4 4.", "World wars", "pictureFilename", new Location(0.80429f, 0.25632f, "01_surface"), 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 5", "Hint1 5. Hint2 5. Hint3 5. Hint4 5.", "World wars", "pictureFilename", new Location(0.76f, 0.37907f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 6", "Hint1 6. Hint2 6. Hint3 6. Hint4 6.", "World wars", "pictureFilename", new Location(0.74429f, 0.45247f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 7", "Hint1 7. Hint2 7. Hint3 7. Hint4 7.", "World wars", "pictureFilename", new Location(0.74286f, 0.55115f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 8", "Hint1 8. Hint2 8. Hint3 8. Hint4 8.", "World wars", "pictureFilename", new Location(0.77858f, 0.62816f, "01_surface"), 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 9", "Hint1 9. Hint2 9. Hint3 9. Hint4 9.", "World wars", "pictureFilename", new Location(0.5816f, 0.13183f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 10", "Hint1 10. Hint2 10. Hint3 10. Hint4 10.", "World wars", "pictureFilename", new Location(0.69326f, 0.14371f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 11", "Hint1 11. Hint2 11. Hint3 11. Hint4 11.", "World wars", "pictureFilename", new Location(0.69326f, 0.33848f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 12", "Hint1 12. Hint2 12. Hint3 12. Hint4 12.", "World wars", "pictureFilename", new Location(0.69326f, 0.43943f, "02_second"), 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("партизан артефакт 13", "Hint1 13. Hint2 13. Hint3 13. Hint4 13.", "World wars", "pictureFilename", new Location(0.69694f, 0.72447f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 14", "Hint1 14. Hint2 14. Hint3 14. Hint4 14.", "World wars", "pictureFilename", new Location(0.83927f, 0.73178f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 15", "Hint1 15. Hint2 15. Hint3 15. Hint4 15.", "World wars", "pictureFilename", new Location(0.92639f, 0.68647f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("партизан артефакт 16", "Hint1 16. Hint2 16. Hint3 16. Hint4 16.", "World wars", "pictureFilename", new Location(0.93007f, 0.79692f, "02_second"), 4);
    artifacts.add(artifact);
    
    // Ancient warrior
    artifact = new Artifact("антички воин артефакт 1", "Hint1 1. Hint2 1. Hint3 1. Hint4 1.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.09715f, 0.70999f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 2", "Hint1 2. Hint2 2. Hint3 2. Hint4 2.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.22572f, 0.75452f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 3", "Hint1 3. Hint2 3. Hint3 3. Hint4 3.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.37143f, 0.70879f, "01_surface"), 1);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 4", "Hint1 4. Hint2 4. Hint3 4. Hint4 4.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.45714f, 0.75572f, "01_surface"), 1);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 5", "Hint1 5. Hint2 5. Hint3 5. Hint4 5.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.53286f, 0.75452f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 6", "Hint1 6. Hint2 6. Hint3 6. Hint4 6.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.76f, 0.70759f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 7", "Hint1 7. Hint2 7. Hint3 7. Hint4 7.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.77858f, 0.86643f, "01_surface"), 2);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 8", "Hint1 8. Hint2 8. Hint3 8. Hint4 8.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.90858f, 0.70037f, "01_surface"), 2);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 9", "Hint1 9. Hint2 9. Hint3 9. Hint4 9.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.14111f, 0.7411f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 10", "Hint1 10. Hint2 10. Hint3 10. Hint4 10.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.26013f, 0.73635f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 11", "Hint1 11. Hint2 11. Hint3 11. Hint4 11.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.38037f, 0.72922f, "02_second"), 3);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 12", "Hint1 12. Hint2 12. Hint3 12. Hint4 12.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.47362f, 0.72447f, "02_second"), 3);
    artifacts.add(artifact);
    
    artifact = new Artifact("антички воин артефакт 13", "Hint1 13. Hint2 13. Hint3 13. Hint4 13.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.58528f, 0.72803f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 14", "Hint1 14. Hint2 14. Hint3 14. Hint4 14.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.61105f, 0.77554f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 15", "Hint1 15. Hint2 15. Hint3 15. Hint4 15.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.26749f, 0.81711f, "02_second"), 4);
    artifacts.add(artifact);
    artifact = new Artifact("антички воин артефакт 16", "Hint1 16. Hint2 16. Hint3 16. Hint4 16.", "Ancient Greek and Persian wars", "pictureFilename", new Location(0.27362f, 0.91449f, "02_second"), 4);
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
