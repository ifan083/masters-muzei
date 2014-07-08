package com.example.textrecoapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.TextView;

import com.example.textrecoapp.ar.CameraPreview;
import com.example.textrecoapp.ar.ScanningResult;
import com.example.textrecoapp.characters.Character;
import com.example.textrecoapp.gameplay.Artifact;

public class OCRActivity extends Activity implements ScanningResult {

  // settings
  public static final String PHOTO_TAKEN = "photo_taken";
  public static final String LOG_TAG = "OCRActivity";

  private Camera camera;

  // ui
  private FrameLayout surfaceViewContainer;
  private Button scanBtn;
  private View progressBar;

  private TextView hint;
  private ImageView characterImg;
  private Button nextHintBtn;

  private ImageView scannedImage;
  private TextView scannedResult;
  private AlertDialog dialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    initUI();
  }

  private void initUI() {
    camera = Camera.open();
    CameraPreview preview = new CameraPreview(this, camera);
    surfaceViewContainer = (FrameLayout) findViewById(R.id.surface_view_container);
    surfaceViewContainer.addView(preview);

    hint = (TextView) findViewById(R.id.hint_view);
    characterImg = (ImageView) findViewById(R.id.character_img);
    nextHintBtn = (Button) findViewById(R.id.next_hint);

    updateCharacterSpecificUI();

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

  private void updateCharacterSpecificUI() {
    final Character character = App.getInstance().getCharacterManager().getCharacter();
    hint.setText(character.getMission().getHint());
    characterImg.setImageResource(UiUtils.getImageDrawableId(this, character.getPictureFilename()));
    nextHintBtn.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        hint.setText(character.getMission().getHint());
      }
    });
  }

  private void prepareScanningDialog(final Bitmap bmp) {
    View view = getLayoutInflater().inflate(R.layout.scan_dialog_layout, null);

    scannedResult = (TextView) view.findViewById(R.id.scan_result_tv);
    scannedImage = (ImageView) view.findViewById(R.id.scanned_imag);
    scannedImage.setImageBitmap(bmp);

    ImageOcrProcessing task = new ImageOcrProcessing(progressBar, App.getInstance().getOCR_API(), OCRActivity.this);
    task.execute(bmp);

    String title = getResources().getString(R.string.title_scan_dialog);
    String posBtnText = getResources().getString(R.string.submit);
    String negBtnText = getResources().getString(R.string.retry);

    DialogInterface.OnClickListener posListener = new DialogInterface.OnClickListener() {

      @Override
      public void onClick(DialogInterface dialog, int which) {
        String scannedText = String.valueOf(scannedResult.getText());
        
        Character character = App.getInstance().getCharacterManager().getCharacter();
        //get the mission status
        int result = character.getMission().tryAnswer(scannedText);
        //find its state 
        Artifact artifact = App.getInstance().getCartographer().findArtifact(scannedText);
        
        Intent intent = new Intent();
        intent.putExtra(CharacterSelectorActivity.EXTRAS_MISSION_STATUS, result);
        intent.putExtra(CharacterSelectorActivity.EXTRAS_MISSION_ARTIFACT, artifact);
        setResult(Activity.RESULT_OK, intent);
        finish();
      }
    };

    DialogInterface.OnClickListener negListener = new DialogInterface.OnClickListener() {

      @Override
      public void onClick(DialogInterface dialog, int which) {
        camera.startPreview();
      }
    };

    dialog = UiUtils.createDialogWithImageView(this, title, posBtnText, negBtnText, view, posListener, negListener);
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
    scannedResult.setText(resultString);
    dialog.show();
  }

}
