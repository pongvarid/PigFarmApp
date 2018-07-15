package com.pitipong.android.pigfarm.dal;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by manao on 1/24/2017 AD.
 */

public class PreferenceManager {

    public static final String PREFERENCES = "TEXT_RESOURCES";
    private SharedPreferences sharedpreferences;

    private final String isLogin = "isLogin";
    private final String accessToken = "accessToken";

    private final String name = "name";
    private final String email = "email";
    
    public PreferenceManager(Context context) {
        sharedpreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setIsLogin(boolean sIsLogin) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(isLogin, sIsLogin);
        editor.commit();
    }

    public boolean getIsLogin() {
        if (sharedpreferences.contains(isLogin)) {
            return sharedpreferences.getBoolean(isLogin, false);
        }
        return false;
    }

    public void setAccessToken(String sAccessToken) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(accessToken, sAccessToken);
        editor.commit();
    }

    public String getAccessToken() {
        if (sharedpreferences.contains(accessToken)) {
            return sharedpreferences.getString(accessToken, null);
        }
        return null;
    }

    public void setName(String sName) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(name, sName);
        editor.commit();
    }

    public String getName() {
        if (sharedpreferences.contains(name)) {
            return sharedpreferences.getString(name, null);
        }
        return null;
    }

    public void setEmail(String sEmail) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(email, sEmail);
        editor.commit();
    }

    public String getEmail() {
        if (sharedpreferences.contains(email)) {
            return sharedpreferences.getString(email, null);
        }
        return null;
    }

    public boolean getIS_PERMISSIONS_RATIONALE_CAMERA() {
        if (sharedpreferences.contains("IS_PERMISSIONS_RATIONALE_CAMERA")) {
            return sharedpreferences.getBoolean("IS_PERMISSIONS_RATIONALE_CAMERA", false);
        }
        return false;
    }

    public void setIS_PERMISSIONS_RATIONALE_CAMERA(boolean b) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("IS_PERMISSIONS_RATIONALE_CAMERA", b);
        editor.commit();
    }

}
