package com.example.textrecoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.textrecoapp.ar.CameraPreview;
import com.example.textrecoapp.ar.ScanningResult;
import com.example.textrecoapp.ar.TrainSetHandler;
import com.googlecode.tesseract.android.TessBaseAPI;

public class MainActivity extends Activity implements ScanningResult {

  // settings
  public static final String PHOTO_TAKEN = "photo_taken";
  public static final String LOG_TAG = "MainActivity";

  private Camera camera;

  // ui
  private FrameLayout surfaceViewContainer;
  private Button scanBtn;
  private View progressBar;

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
    camera = Camera.open();
    CameraPreview preview = new CameraPreview(this, camera);
    surfaceViewContainer = (FrameLayout) findViewById(R.id.surface_view_container);
    surfaceViewContainer.addView(preview);

    scanBtn = (Button) findViewById(R.id.scan_btn);
    progressBar = findViewById(R.id.progress_overlay);

    final int scanAreaWidth = getResources().getDimensionPixelOffset(R.dimen.scan_area_width);
    final int scanAreaHeight = getResources().getDimensionPixelOffset(R.dimen.scan_area_height);

    scanBtn.setOnClickListener(new OnClickListener() {

      @Override
      public void onClick(View v) {
        camera.takePicture(null, null, new PictureCallback() {

          @Override
          public void onPictureTaken(byte[] data, Camera camera) {
            Bitmap bmp = prepareBitmapFromCamera(data, scanAreaWidth, scanAreaHeight);
            prepareScanningDialog(bmp);
          }
        });
      }
    });
  }

  private void prepareScanningDialog(final Bitmap bmp) {
    ImageView imgView = new ImageView(this);
    imgView.setImageBitmap(bmp);

    String title = "Scanned area";
    String posBtnText = "Scan image";
    String negBtnText = "Retry";

    DialogInterface.OnClickListener posListener = new DialogInterface.OnClickListener() {

      @Override
      public void onClick(DialogInterface dialog, int which) {
        ImageOcrProcessing task = new ImageOcrProcessing(progressBar, ocrAPI, MainActivity.this);
        task.execute(bmp);
      }
    };

    DialogInterface.OnClickListener negListener = new DialogInterface.OnClickListener() {

      @Override
      public void onClick(DialogInterface dialog, int which) {
        camera.startPreview();
      }
    };

    AlertDialog dialog =
        UiUtils.createDialogWithImageView(this, title, posBtnText, negBtnText, imgView, posListener, negListener);
    dialog.show();
  }

  private Bitmap prepareBitmapFromCamera(byte[] data, int scanAreaWidth, int scanAreaHeight) {
    Bitmap source = BitmapFactory.decodeByteArray(data, 0, data.length);

    float wfact = source.getWidth() / (float) surfaceViewContainer.getWidth();
    float hfact = source.getHeight() / (float) surfaceViewContainer.getHeight();

    int picScanWidth = (int) (wfact * scanAreaWidth);
    int picScanHeight = (int) (hfact * scanAreaHeight);

    int x = source.getWidth() / 2 - picScanWidth / 2;
    int y = source.getHeight() / 2 - picScanHeight / 2;

    Bitmap bmp = Bitmap.createBitmap(source, x, y, picScanWidth, picScanHeight);
    source.recycle();
    return bmp;
  }

  @Override
  protected void onPause() {
    super.onPause();

    if (camera != null) {
      camera.release();
      camera = null;
    }
  }

  @Override
  protected void onResume() {
    super.onResume();

    if (camera == null) {
      camera = Camera.open();
    }
  }

  @Override
  public void onScanningFinished(String resultString) {
    Toast.makeText(this, resultString, Toast.LENGTH_SHORT).show();
    camera.startPreview();
  }

}
