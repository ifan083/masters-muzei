/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.characters;

import java.util.Map;

import com.example.textrecoapp.gameplay.Artifact;

public class Cartographer {

  private String mapFilename;
  // NOTE: boolean value: unlocked(true) vs. locked(false) artifact
  private Map<Artifact, Boolean> artifacts;

  public Cartographer(String mapFilename, Map<Artifact, Boolean> artifacts) {
    this.mapFilename = mapFilename;
    this.artifacts = artifacts;
  }

  public String getMapFilename() {
    return mapFilename;
  }

  public Map<Artifact, Boolean> getArtifacts() {
    return artifacts;
  }

  public Artifact findArtifact(String artifactName) {
    Artifact desiredArtifact = null;
    for (Map.Entry<Artifact, Boolean> entry : artifacts.entrySet()) {
      if (entry.getKey().getName().equals(artifactName)) {
        desiredArtifact = entry.getKey();
        break;
      }
    }
    return desiredArtifact;
  }

  public void unlockArtifact(Artifact artifact) {
    artifacts.remove(artifact);
    artifacts.put(artifact, new Boolean(true));
  }

}
