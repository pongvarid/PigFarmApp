package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pitipong.android.pigfarm.R;

public class PigIDActivity extends BaseActivity {

    private static final String TAG = "PigIDActivity";

    private ImageView imageViewBack;
    private TextView textViewInsertCode, textViewScanBarCode;

    private boolean isSoundCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pig_id);
        initView();
    }

    private void initView() {
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
                checkPathToGo();
            }
        });

        textViewScanBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPathToGo();
            }
        });
    }

    private void checkPathToGo() {
        isSoundCard = getIntent().getExtras().getBoolean("isSoundCard");
        if (isSoundCard) {
            startActivity(new Intent(PigIDActivity.this, SoundCardActivity.class));
        } else {
            startActivity(new Intent(PigIDActivity.this, MainActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
       finish();
    }
}
