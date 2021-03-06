package com.pitipong.android.pigfarm.api.response;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class ErrorResponse {

    @SerializedName("email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
