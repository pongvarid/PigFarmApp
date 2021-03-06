package com.pitipong.android.pigfarm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pitipong.android.pigfarm.Application;
import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.api.Api;
import com.pitipong.android.pigfarm.api.request.LoginRequest;
import com.pitipong.android.pigfarm.api.response.LoginResponse;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import static com.pitipong.android.pigfarm.dal.Constant.DELAY_FOR_INTENT_TO_ANOTHER_ACTIVITY;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginFormActivity";

//    private LoginModel loginModel;

    private TextView textViewDesc;
    private EditText edtEmail, edtPassword;
    private Button buttonSubmit;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmail = (EditText) findViewById(R.id.edittext_email);
        edtPassword = (EditText) findViewById(R.id.edittext_password);
        textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        buttonSubmit = (Button) findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmail.getText().toString().trim().length() == 0) {
                    edtEmail.setError("Email can't empty");
                } else {
                    edtEmail.setError(null);
                    if (edtPassword.getText().toString().trim().length() == 0) {
                        edtPassword.setError("Password can't empty");
                    } else {
                        if (!edtEmail.getText().toString().trim().matches(emailPattern)) {
                            edtEmail.setError("Invalid email address");
                        } else {
                            textViewDesc.setText("Loading...");
                            textViewDesc.setTextColor(getResources().getColor(R.color.gray));
                            buttonSubmit.setClickable(false);
                            showLoadingProgress();
                            postLogin(edtEmail.getText().toString(), edtPassword.getText().toString());
                        }
                    }
                }
            }
        });

        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (edtEmail.getText().toString().trim().length() <= 0) {
                    edtEmail.setError("Email can't empty");
                } else {
                    edtEmail.setError(null);
                }
            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (edtPassword.getText().toString().trim().length() <= 0) {
                    edtPassword.setError("Password can't empty");
                } else {
                    edtPassword.setError(null);
                }
            }
        });
    }

    private void postLogin(String email, String password) {
        String emailMock = "admin@app.com";
        String passwordMock = "password";
        Call<LoginResponse> loginModelCall = Api.getInstance(this).getService().postLogin(new LoginRequest(email, password));
        loginModelCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Response<LoginResponse> response, Retrofit retrofit) {
                Log.e(TAG, "onResponse: " + response.raw());
                if (response.code() == 200) {
                    Application.pm.setName(response.body().getName());
                    Application.pm.setEmail(response.body().getEmail());
                    Application.pm.setAccessToken(response.body().getAccessToken());
                    setValueToTextViewDesc(true);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dismissLoadingProgress();
                            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                            finish();
                        }
                    },DELAY_FOR_INTENT_TO_ANOTHER_ACTIVITY);
                } else {
                    dismissLoadingProgress();
                    setValueToTextViewDesc(false);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                setValueToTextViewDesc(false);
                dismissLoadingProgress();
            }
        });
    }

    private void setValueToTextViewDesc(boolean isSuccess){
        if (isSuccess){
            textViewDesc.setTextColor(ContextCompat.getColor(this, R.color.green));
            textViewDesc.setText("Success");
        } else {
            textViewDesc.setTextColor(ContextCompat.getColor(this, R.color.red));
            textViewDesc.setText("Something went wrong");
        }
        buttonSubmit.setClickable(true);
        Application.pm.setIsLogin(isSuccess);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
