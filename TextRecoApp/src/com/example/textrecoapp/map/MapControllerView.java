/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class MapControllerView extends ScrollableZoomableImageView {

  private BuildingNavigator navigator;
  
  //bitmaps 
  //locked
  //unlocked
  //toalet

  public MapControllerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public MapControllerView(Context context) {
    super(context);
    init();
  }

  private void init() {

  }

  public void setNavigator(BuildingNavigator navigator) {
    this.navigator = navigator;
  }

  @Override
  protected void drawPins(Canvas canvas) {
    super.drawPins(canvas);
    
    
  }
  
  @Override
  protected void handleClickEvent(int x, int y) {
    super.handleClickEvent(x, y);
    
  }
}
