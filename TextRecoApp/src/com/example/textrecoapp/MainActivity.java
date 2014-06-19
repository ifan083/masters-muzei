package com.example.textrecoapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MainActivity extends Activity implements Callback {

  public static final String DATA_PATH = Environment.getExternalStorageDirectory().toString() + "/TextRecoApp";
  public static final String LANG = "mkd";
  public static final String PHOTO_TAKEN = "photo taken";
  public static final String LOG_TAG = "MainActivity";

  private Camera camera;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initDirectory();
    setContentView(R.layout.activity_main);
    initUI();
  }

  private void initDirectory() {
    String[] paths = new String[]{DATA_PATH, DATA_PATH + "/tessdata/"};
    for (String path : paths) {
      File dir = new File(path);
      if (!dir.exists()) {
        if (!dir.mkdirs()) {
          Log.e(LOG_TAG, "ERROR: Creation of directory " + path + " on SD Card failed");
          return;
        } else {
          Log.v(LOG_TAG, "Created directory " + path + " on SD Card");
        }
      }
    }

    checkAndCreateTrainedData();
  }

  private void checkAndCreateTrainedData() {
    if (!(new File(DATA_PATH + "/tessdata/" + LANG + ".traineddata")).exists()) {
      try {
        AssetManager assetsManager = getAssets();
        InputStream is = assetsManager.open(LANG + ".traineddata");
        OutputStream os = new FileOutputStream(DATA_PATH + "/tessdata/" + LANG + "traineddata");

        byte[] buffer = new byte[1024];
        int lenght;

        while ((lenght = is.read(buffer)) > 0) {
          os.write(buffer, 0, lenght);
        }

        is.close();
        os.close();

        Log.v(LOG_TAG, "Copied " + LANG + ".traineddata");
      } catch (Exception e) {
        Log.e(LOG_TAG, "Was unable to copy " + LANG + ".traineddata");
      }
    }
  }

  private void initUI() {
    SurfaceView surface = (SurfaceView) findViewById(R.id.surface_view);

    SurfaceHolder holder = surface.getHolder();
    holder.addCallback(this);
    holder.setFixedSize(400, 300);
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    try {
      camera.setPreviewDisplay(holder);
      camera.startPreview();
    } catch (IOException e) {
      Log.e(LOG_TAG, "Error when starting the app");
    }
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    // camera.stopPreview();
  }

  @Override
  protected void onPause() {
    super.onPause();
    camera.stopPreview();
    camera.release();
  }

  @Override
  protected void onResume() {
    super.onResume();
    camera = Camera.open();
  }

}
