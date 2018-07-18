package com.pitipong.android.pigfarm.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.pitipong.android.pigfarm.R;

public class ProfileActivity extends BaseActivity {

    private EditText
            edittextName,
            edittextLastName,
            edittextOldPassword,
            edittextNewPassword,
            edittextConfirmNewPassword;

    private ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();
    }

    private void initView(){
        imageViewBack = findViewById(R.id.imageViewBack);

        edittextName = findViewById(R.id.edittextName);
        edittextLastName = findViewById(R.id.edittextLastName);
        edittextOldPassword = findViewById(R.id.edittextOldPassword);
        edittextNewPassword = findViewById(R.id.edittextNewPassword);
        edittextConfirmNewPassword = findViewById(R.id.edittextConfirmNewPassword);

        initClickEvent();
    }

    private void initClickEvent(){
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
