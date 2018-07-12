package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.api.response.BaseResponse;
import com.pitipong.android.pigfarm.helper.MessageBox;
import com.pitipong.android.pigfarm.util.KeyboardHelper;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SearchPigIDActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private FrameLayout cameraPreview;
    private EditText edittextSearchID;
    private ImageView imageViewBack, imageViewSearch;


    private boolean isSoundCard;
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pig_id);
        initView();
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

                checkPathToGo();

                if (edittextSearchID.getText().length() > 0){

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

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onResume() {
        super.onResume();
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

    }
}
