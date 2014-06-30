/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gameplay;

public final class MissionGenerator {

  private MissionGenerator instance;

  public MissionGenerator getInstance() {
    if (instance == null) {
      instance = new MissionGenerator();
    }
    return instance;
  }

  private MissionGenerator() {
    init();
  }

  private void init() {

  }

  /**
   * Generates unique mission.
   * 
   * @param category == characterName
   * @param difficulty
   * @return newly generated mission based on the input variables
   */
  public MissionContext generateMissionForCharacter(String category, int difficulty) {
    return null;
  }
}
