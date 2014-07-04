/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp.map;

import com.example.textrecoapp.gameplay.Artifact;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.util.AttributeSet;

public class MapControllerView extends ScrollableZoomableImageView {

  private BuildingNavigator navigator;

  private float[] matrixValues = new float[9];

  private int bitmapWidth;
  private int bitmapHeight;

  // bitmaps
  // locked
  // unlocked
  // toalet

  public MapControllerView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public MapControllerView(Context context) {
    super(context);
    init();
  }

  private void init() {
    bitmapWidth = getDrawable().getIntrinsicWidth();
    bitmapHeight = getDrawable().getIntrinsicHeight();
  }

  public void setNavigator(BuildingNavigator navigator) {
    this.navigator = navigator;
    updatePinBitmaps();
    invalidate();
  }

  private void updatePinBitmaps() {
    for (Pin p : navigator.getStoreyState().getPins()) {
      p.setBitmap(getBitmapForArtifact(p.getArtifact()));
    }
  }

  private Bitmap getBitmapForArtifact(Artifact artifact) {
    // TODO Auto-generated method stub
    return null;
  }

  private void changeFloor(String newFloorId) {
    navigator.changeStorey(newFloorId);
    updatePinBitmaps();
    invalidate();
  }

  @Override
  protected void drawPins(Canvas canvas) {
    super.drawPins(canvas);
    calculateNewestMatrixChanges();

  }

  private void calculateNewestMatrixChanges() {
    getMapMatrix().getValues(matrixValues);
  }

  @Override
  protected void handleClickEvent(int x, int y) {
    super.handleClickEvent(x, y);

  }

  protected Point transformMapToScreenPoint(float x, float y) {
    int correctedX = (int) (bitmapWidth * x);
    int correctedY = (int) (bitmapHeight * y);
    int pinX = (int) (correctedX * matrixValues[Matrix.MSCALE_X] + matrixValues[Matrix.MTRANS_X]);
    int pinY = (int) (correctedY * matrixValues[Matrix.MSCALE_Y] + matrixValues[Matrix.MTRANS_Y]);
    return new Point(pinX, pinY);
  }

  private void drawPin(Canvas canvas, Pin pin) {
    Bitmap bitmap = pin.getBitmap();
    int offsetX = bitmap.getWidth() / 2;
    int offsetY = bitmap.getHeight() / 2;
    Point p = transformMapToScreenPoint(pin.getX(), pin.getY());
    canvas.drawBitmap(pin.getBitmap(), p.x - offsetX, p.y - offsetY, null);
  }
}
