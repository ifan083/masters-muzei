package com.example.textrecoapp;

import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.textrecoapp.ar.TrainSetHandler;
import com.googlecode.tesseract.android.TessBaseAPI;

public class MainActivity extends Activity implements Callback {

  // paths
  public static final String PHOTO_PATH = Environment.getExternalStorageDirectory().toString()
      + "images/dummy_photo.jpg";

  // settings
  public static final String PHOTO_TAKEN = "photo taken";
  public static final String LOG_TAG = "MainActivity";

  private Camera camera;

  // ui
  private SurfaceView surfaceView;
  private View scanArea;
  private Button scanBtn;
  private ImageView scanResult;

  // OCR
  private TessBaseAPI ocrAPI;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    TrainSetHandler tsh = new TrainSetHandler(this, "mkd");
    tsh.initDirectory();

    new Runnable() {

      @Override
      public void run() {
        initOCR_API();
      }
    }.run();;

    setContentView(R.layout.activity_main);
    initUI();
  }

  private void initOCR_API() {
    ocrAPI = new TessBaseAPI();
    ocrAPI.init(TrainSetHandler.DATA_PATH, "mkd");
  }

  private void initUI() {
    surfaceView = (SurfaceView) findViewById(R.id.surface_view);

    SurfaceHolder holder = surfaceView.getHolder();
    holder.addCallback(this);

    scanArea = findViewById(R.id.scan_area);
    scanBtn = (Button) findViewById(R.id.scan_btn);
    scanResult = (ImageView) findViewById(R.id.result_img);

    final int scanAreaWidth = getResources().getDimensionPixelOffset(R.dimen.scan_area_width);
    final int scanAreaHeight = getResources().getDimensionPixelOffset(R.dimen.scan_area_height);
    scanBtn.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        camera.takePicture(null, null, new PictureCallback() {

          @Override
          public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap source = BitmapFactory.decodeByteArray(data, 0, data.length);

            float wfact = source.getWidth() / (float) surfaceView.getWidth();
            float hfact = source.getHeight() / (float) surfaceView.getHeight();

            int picScanWidth = (int) (wfact * scanAreaWidth);
            int picScanHeight = (int) (hfact * scanAreaHeight);

            int x = source.getWidth() / 2 - picScanWidth / 2;
            int y = source.getHeight() / 2 - picScanHeight / 2;

            Bitmap bmp = Bitmap.createBitmap(source, x, y, picScanWidth, picScanHeight);
            source.recycle();

            scanResult.setImageBitmap(bmp);

            ocrAPI.setImage(bmp);
            String recongizedtext = ocrAPI.getUTF8Text();
            Toast.makeText(MainActivity.this, recongizedtext, Toast.LENGTH_SHORT).show();
          }
        });

      }
    });
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
