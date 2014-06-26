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

}
