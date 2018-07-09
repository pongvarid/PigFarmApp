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
    private final String memberToken = "memberToken";
    
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

    public void setMemberToken(String sMemberToken) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(memberToken, sMemberToken);
        editor.commit();
    }

    public String getMemberToken() {
        if (sharedpreferences.contains(memberToken)) {
            return sharedpreferences.getString(memberToken, null);
        }
        return null;
    }

}
