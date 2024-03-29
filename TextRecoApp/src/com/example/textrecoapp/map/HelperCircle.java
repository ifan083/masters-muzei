/*
 * Copyright (C) 2014 by Netcetera AG.
 * All rights reserved.
 *
 * The copyright to the computer program(s) herein is the property of Netcetera AG, Switzerland.
 * The program(s) may be used and/or copied only with the written permission of Netcetera AG or
 * in accordance with the terms and conditions stipulated in the agreement/contract under which 
 * the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import android.graphics.PointF;


public class HelperCircle {

  private PointF center;
  private PointF periferial;
  
  public HelperCircle(PointF center, PointF periferial) {
    this.center = center;
    this.periferial = periferial;
  }

  public PointF getCenter() {
    return center;
  }
  
  public PointF getPeriferial() {
    return periferial;
  }
  
}
