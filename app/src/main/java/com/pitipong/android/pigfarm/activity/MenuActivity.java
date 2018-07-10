package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.helper.MessageBox;
import com.pitipong.android.pigfarm.listener.IButtonEventListener;

public class MenuActivity extends BaseActivity {

    private TextView
            textViewName,
            textViewManagePersonalData,
            textViewManageMotherBreed,
            textViewCreateSoundCard,
            textViewTakeVaccine,
            textViewLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initView();
    }

    private void initView() {
        textViewName = findViewById(R.id.textViewName);
        textViewManagePersonalData = findViewById(R.id.textViewManagePersonalData);
        textViewManageMotherBreed = findViewById(R.id.textViewManageMotherBreed);
        textViewCreateSoundCard = findViewById(R.id.textViewCreateSoundCard);
        textViewTakeVaccine = findViewById(R.id.textViewTakeVaccine);
        textViewLogout = findViewById(R.id.textViewLogout);

        bindView();
        initEventOnClick();
    }

    private void bindView(){
        textViewName.setText("สวัสดี "+Application.pm.getName());
    }

    private void initEventOnClick(){
        textViewManagePersonalData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ProfileActivity.class));
            }
        });
        textViewManageMotherBreed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PigIDActivity.class);
                intent.putExtra("isSoundCard", false);
                startActivity(intent);
            }
        });
        textViewCreateSoundCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, PigIDActivity.class);
                intent.putExtra("isSoundCard", true);
                startActivity(intent);
            }
        });
        textViewTakeVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, VaccineActivity.class));
            }
        });
        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageBox.getInstance().alertMessageWithCallback(
                        "Logout?",
                        "Yes",
                        "No",
                        MenuActivity.this, new IButtonEventListener() {
                            @Override
                            public void onClickPositive() {
                                Application.pm.setIsLogin(false);
                                Application.pm.setEmail("");
                                Application.pm.setMemberToken("");
                                Application.pm.setName("");
                                finishAffinity();
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
        backToExitApp();
    }
}