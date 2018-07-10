package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitipong.android.pigfarm.R;

public class PigIDActivity extends BaseActivity {

    private ImageView imageViewBack;
    private TextView textViewInsertCode, textViewScanBarCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_id);
        initView();
    }

    private void initView(){
        imageViewBack = findViewById(R.id.imageViewBack);
        textViewInsertCode = findViewById(R.id.textViewInsertCode);
        textViewScanBarCode = findViewById(R.id.textViewScanBarCode);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textViewInsertCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PigIDActivity.this, MainActivity.class));
            }
        });

        textViewScanBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PigIDActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        backToExitApp();
    }
}
