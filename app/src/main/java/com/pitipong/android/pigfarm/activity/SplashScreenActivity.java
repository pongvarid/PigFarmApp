package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pitipong.android.pigfarm.R;

import static com.pitipong.android.pigfarm.dal.Constant.DELAY_FOR_SPLASH_SCREEN;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        intentToMainActivity();
    }

    private void intentToMainActivity(){
        final Intent intent = new Intent(this, MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },DELAY_FOR_SPLASH_SCREEN);
    }
}
