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
import android.view.View;

public final class UiUtils {

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

}
