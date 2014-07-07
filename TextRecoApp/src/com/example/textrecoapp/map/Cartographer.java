/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import java.util.List;

import com.example.textrecoapp.gameplay.Artifact;

public class Cartographer {
  
  public static final String CARTOGRAPHER = "cartographer";

  private BuildingNavigator navigator;
  private List<Artifact> artifacts;

  public Cartographer(List<Floor> floors, List<Artifact> artifacts) {
    this.artifacts = artifacts;
    navigator = new BuildingNavigator(floors, this.artifacts);
  }

  public List<Artifact> getArtifacts() {
    return artifacts;
  }

  public Artifact findArtifact(String artifactName) {
    Artifact desiredArtifact = null;
    for (Artifact a : artifacts) {
      if (a.getName().equals(artifactName)) {
        desiredArtifact = a;
        break;
      }
    }
    return desiredArtifact;
  }

  public void unlockArtifact(Artifact artifact) {
    artifact.unlockArtefact();
  }

  public BuildingNavigator getNavigator() {
    return navigator;
  }
  
}
