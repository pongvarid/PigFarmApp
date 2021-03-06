package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;

import static com.pitipong.android.pigfarm.dal.Constant.DELAY_FOR_SPLASH_SCREEN;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        Application.pm.setIsLogin(true);
        intentToActivity();
//        Application.pm.setAccessToken(URL_FIX_TOKEN);
    }

    private void intentToActivity(){
        final Intent intent;
        if (Application.pm.getIsLogin()){
            intent = new Intent(this, MenuActivity.class);
        } else {
            intent = new Intent(this, LoginActivity.class);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(intent);
                finish();
            }
        },DELAY_FOR_SPLASH_SCREEN);
    }
}
