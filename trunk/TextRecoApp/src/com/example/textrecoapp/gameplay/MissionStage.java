/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

import android.annotation.SuppressLint;

import java.io.Serializable;
import java.util.Random;

public class MissionStage implements Serializable {

  private Artifact artifact;
  private Random randomGenerator;

  public MissionStage(Artifact artifact) {
    this.artifact = artifact;
    randomGenerator = new Random();
  }

  public boolean tryAnswer(String newTry) {
    return artifact.getName().equals(newTry);
  }

  public String getHint() {
    String[] sentences = artifact.getDescription().split("\\.");

    int sentenceIndicator = 0;
    do {
      sentenceIndicator = randomGenerator.nextInt(sentences.length);
    } while (isNotValidSentence(artifact.getName(), sentences[sentenceIndicator]));

    return sentences[sentenceIndicator];
  }

  @SuppressLint("DefaultLocale")
  private boolean isNotValidSentence(String answer, String sentence) {
    return sentence.toLowerCase().contains(answer);
  }

  public Artifact getArtifact() {
    return artifact;
  }

}
