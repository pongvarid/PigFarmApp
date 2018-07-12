package com.pitipong.android.pigfarm.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.pitipong.android.pigfarm.R;

public class BaseActivity extends AppCompatActivity {

    private long lastBackPressTime = 0;
    private Toast mToastWarningMessage;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showLoadingProgress() {
        progressDialog = new ProgressDialog(this, R.style.TransparentDialogProgressbar);
        progressDialog.getWindow().setDimAmount(0.4f);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    public void dismissLoadingProgress() {
        if (progressDialog != null)
            progressDialog.dismiss();
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
