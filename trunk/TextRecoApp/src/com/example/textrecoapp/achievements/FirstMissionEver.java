/*
 * Copyright (C) 2014 by Netcetera AG.
 * All rights reserved.
 *
 * The copyright to the computer program(s) herein is the property of Netcetera AG, Switzerland.
 * The program(s) may be used and/or copied only with the written permission of Netcetera AG or
 * in accordance with the terms and conditions stipulated in the agreement/contract under which 
 * the program(s) have been supplied.
 */
package com.example.textrecoapp.achievements;

import com.example.textrecoapp.gameplay.MissionContext;
import com.example.textrecoapp.gamification.AchievementCriteria;


public class FirstMissionEver extends AchievementCriteria {

  private static final long serialVersionUID = 8342637163187393474L;

  @Override
  public boolean checkCriteria(MissionContext mission) {
    return true;
  }

}
