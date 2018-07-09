package com.pitipong.android.pigfarm.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pw on 14/5/2018 AD.
 */

public class BaseResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("errors")
    private List<ErrorResponse> errorResponse;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorResponse> getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(List<ErrorResponse> errorResponse) {
        this.errorResponse = errorResponse;
    }
}
