package com.pitipong.android.pigfarm.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.pitipong.android.pigfarm.R;

public class BaseActivity extends AppCompatActivity {

    private long lastBackPressTime = 0;
    private Toast mToastWarningMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void backToExitApp() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 2000) {
            mToastWarningMessage = Toast.makeText(this, this.getString(R.string.warning_message_close_the_app), Toast.LENGTH_SHORT);
            mToastWarningMessage.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (mToastWarningMessage != null) {
                mToastWarningMessage.cancel();
                moveTaskToBack(true);
            }
        }
    }
}
