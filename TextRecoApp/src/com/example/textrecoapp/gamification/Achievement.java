/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.gamification;

public class Achievement {

  private String name;
  private int level;
  private String categoryName;
  private String description;

  public Achievement(String name, int level, String categoryName, String description) {
    this.name = name;
    this.level = level;
    this.categoryName = categoryName;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public String getDescription() {
    return description;
  }

}
