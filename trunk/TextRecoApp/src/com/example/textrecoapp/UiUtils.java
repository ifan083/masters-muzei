/*
 * Copyright (C) 2014 by Netcetera AG. All rights reserved. The copyright to the computer program(s)
 * herein is the property of Netcetera AG, Switzerland. The program(s) may be used and/or copied
 * only with the written permission of Netcetera AG or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s) have been supplied.
 */
package com.example.textrecoapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

public final class UiUtils {

  private static final String RES_PREFIX = "muzei_";
  private static final String RES_HIGHLIGHTED = "_highlighted";
  private static final String RES_TYPE_DRAWABLE = "drawable";

  public static AlertDialog createDialogWithImageView(Context context,
      String title,
      String posBtnText,
      String negBtnText,
      View customView,
      DialogInterface.OnClickListener posListener,
      DialogInterface.OnClickListener negListener) {

    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setTitle(title)
        .setView(customView)
        .setPositiveButton(posBtnText, posListener)
        .setNegativeButton(negBtnText, negListener);
    return builder.create();
  }

  public static AlertDialog createSimpleDialog(Context context,
      String title,
      String message,
      String posBtnText,
      String negBtnText,
      DialogInterface.OnClickListener posListener,
      DialogInterface.OnClickListener negListener) {

    AlertDialog.Builder builder = new AlertDialog.Builder(context);
    builder.setTitle(title).setMessage(message).setPositiveButton(posBtnText, posListener);
    builder.setNegativeButton(negBtnText, negListener);

    return builder.create();
  }

  public static StateListDrawable getStateDrawableForId(Context context, String id, boolean hasPrefix) {
    String str_id_regular = (hasPrefix ? RES_PREFIX : "") + id;
    String str_id_pressed = (hasPrefix ? RES_PREFIX : "") + id + RES_HIGHLIGHTED;
    int id_normal = context.getResources().getIdentifier(str_id_regular, RES_TYPE_DRAWABLE, context.getPackageName());
    int id_pressed = context.getResources().getIdentifier(str_id_pressed, RES_TYPE_DRAWABLE, context.getPackageName());

    StateListDrawable stateList = new StateListDrawable();
    stateList.addState(new int[]{android.R.attr.state_pressed}, context.getResources().getDrawable(id_pressed));
    stateList.addState(new int[]{android.R.attr.state_enabled}, context.getResources().getDrawable(id_normal));
    return stateList;
  }

  public static int getImageDrawableId(Context context, String id) {
    int drawableId = context.getResources().getIdentifier(id, RES_TYPE_DRAWABLE, context.getPackageName());
    return drawableId;
  }

  public static void drawHighlightedRectangle(Canvas canvas, Point point) {
    Paint circlePaint = new Paint();
    circlePaint.setStyle(Paint.Style.FILL);
    circlePaint.setColor(Color.BLUE);
    circlePaint.setAlpha(128);

    canvas.drawCircle(point.x, point.y, 50, circlePaint);
  }

  public static void drawCircle(Canvas canvas, Point center, int radius) {
    Paint circlePaint = new Paint();
    circlePaint.setStyle(Paint.Style.FILL);
    circlePaint.setColor(Color.RED);
    circlePaint.setAlpha(128);

    canvas.drawCircle(center.x, center.y, radius, circlePaint);
  }
}
