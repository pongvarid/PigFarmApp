package com.pitipong.android.pigfarm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.pitipong.android.pigfarm.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SearchPigIDActivity extends AppCompatActivity {

    private FrameLayout cameraPreview;
    private ImageView imageViewBack;

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pig_id);
        initView();
    }

    private void initView(){
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
