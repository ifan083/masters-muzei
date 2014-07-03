/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import java.util.ArrayList;
import java.util.List;

public class FloorGenerator {

  private List<Floor> floors;

  private static FloorGenerator instance;

  public static FloorGenerator getInstance() {
    if (instance == null) {
      instance = new FloorGenerator();
    }
    return instance;
  }

  private FloorGenerator() {
    init();
  }

  private void init() {
    floors = new ArrayList<Floor>();

    Floor floor = new Floor("01_surface", "map1", 0);
    floors.add(floor);

    floor = new Floor("02_second", "map2", 1);
    floors.add(floor);
  }

  public List<Floor> getFloors() {
    return floors;
  }
}
