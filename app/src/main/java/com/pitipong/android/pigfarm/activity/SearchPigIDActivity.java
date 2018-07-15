package com.pitipong.android.pigfarm.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.api.Api;
import com.pitipong.android.pigfarm.api.response.PigDataResponse;
import com.pitipong.android.pigfarm.helper.MessageBox;
import com.pitipong.android.pigfarm.listener.IButtonEventListener;
import com.pitipong.android.pigfarm.util.KeyboardHelper;

import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static com.pitipong.android.pigfarm.api.ServiceURL.APPLICATION_JSON;

public class SearchPigIDActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private static final String TAG = "SearchPigIDActivity";

    private FrameLayout cameraPreview;
    private EditText edittextSearchID;
    private ImageView imageViewBack, imageViewSearch;


    private boolean isSoundCard;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pig_id);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
        requestPermissions();
    }

    private void initView(){
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewSearch = findViewById(R.id.imageViewSearch);
        cameraPreview = findViewById(R.id.cameraPreview);
        edittextSearchID = findViewById(R.id.edittextSearchID);

        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        cameraPreview.addView(mScannerView);
        setupUI(cameraPreview);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittextSearchID.getText().length() > 0){
                    checkPathToGo();
                } else {
                    KeyboardHelper.showSoftKeyboard(edittextSearchID);
                }
            }
        });
    }

    public void setupUI(final View view) {
        //Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                   KeyboardHelper.hideKeyboard(SearchPigIDActivity.this, view);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    private void checkPathToGo() {
        isSoundCard = getIntent().getExtras().getBoolean("isSoundCard");
        if (isSoundCard) {
            startActivity(new Intent(SearchPigIDActivity.this, SoundCardActivity.class));
        } else {
            startActivity(new Intent(SearchPigIDActivity.this, MainActivity.class));
        }
    }

    private void getPigData(String pigID){
        Call<PigDataResponse> pigDataResponseCall = Api.getInstance(this).getService().getPigData(
                "Bearer " +Application.pm.getAccessToken(),
                APPLICATION_JSON,APPLICATION_JSON, pigID);
        pigDataResponseCall.enqueue(new Callback<PigDataResponse>() {
            @Override
            public void onResponse(Response<PigDataResponse> response, Retrofit retrofit) {
                if (response.code() == 200){
                    if (response.body() != null){
                        checkPathToGo();
                    } else {
                        MessageBox.getInstance().alertMessage("ไม่พบข้อมูล", SearchPigIDActivity.this, new IButtonEventListener() {
                            @Override
                            public void onClickPositive() {
                                mScannerView.resumeCameraPreview(SearchPigIDActivity.this);
                                edittextSearchID.setText("");
                            }

                            @Override
                            public void onClickNegative() {

                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                MessageBox.getInstance().alertMessage("พบข้อผิดพลาด กรุณาลองอีกครั้ง", SearchPigIDActivity.this, new IButtonEventListener() {
                    @Override
                    public void onClickPositive() {
                        mScannerView.resumeCameraPreview(SearchPigIDActivity.this);
                        edittextSearchID.setText("");
                    }

                    @Override
                    public void onClickNegative() {

                    }
                });

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        edittextSearchID.setText("");
        startCamera();
        MessageBox.getInstance().dismissMessageBox();
    }

    public void onPause() {
        super.onPause();
        stopCamera();
        MessageBox.getInstance().dismissMessageBox();
    }

    public void startCamera() {
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();
    }

    public void stopCamera() {
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        edittextSearchID.setText(result.getText().toString());
        getPigData(result.getText().toString());
    }

    private void requestPermissions(){
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if(report.areAllPermissionsGranted()){
                    startCamera();
                }
                if(report.getDeniedPermissionResponses().size() > 0){
                    Log.d(TAG, "onPermissionDenied");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if(!shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                            if(Application.pm.getIS_PERMISSIONS_RATIONALE_CAMERA()){
                                MessageBox.getInstance().alertMessageWithLaterButton("Please allow permission before using the app", SearchPigIDActivity.this, new IButtonEventListener() {
                                    @Override
                                    public void onClickPositive() {
                                        final Intent i = new Intent();
                                        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                        i.addCategory(Intent.CATEGORY_DEFAULT);
                                        i.setData(Uri.parse("package:" + SearchPigIDActivity.this.getPackageName()));

                                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                                        SearchPigIDActivity.this.startActivity(i);
                                    }

                                    @Override
                                    public void onClickNegative() {

                                    }
                                });
                            }
                            Application.pm.setIS_PERMISSIONS_RATIONALE_CAMERA(true);
                        }
                    }
                }
            }

            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                Log.d(TAG, "onPermissionRationaleShouldBeShown");
                token.continuePermissionRequest();
                Application.pm.setIS_PERMISSIONS_RATIONALE_CAMERA(false);
            }
        }).withErrorListener(new PermissionRequestErrorListener() {
            @Override
            public void onError(DexterError error) {

            }
        }).onSameThread().check();
    }
}
