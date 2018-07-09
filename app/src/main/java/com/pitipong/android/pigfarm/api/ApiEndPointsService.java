package com.pitipong.android.pigfarm.api;


import com.pitipong.android.pigfarm.api.request.LoginRequest;
import com.pitipong.android.pigfarm.api.response.LoginResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

import static com.pitipong.android.pigfarm.api.ServiceURL.URL_LOGIN;

/**
 * Created by pw on 2/5/2016.
 */
public interface ApiEndPointsService {

    String contentType = "application/x-www-form-urlencoded";

    //    @DELETE(URL_DEV)
//    Call<Objects> deleteEvent(
//            @Header("accesstoken") String accesstoken,
//            @Header("zumo-api-version") String zumov,
//            @Header("Cache-Control") String cacheControl,
//            @Path("id") String id);
//
//
//    @PATCH("tables/Events/{id}")
//    Call<Objects> patchCancelEvent(
//            @Header("accesstoken") String accesstoken,
//            @Header("zumo-api-version") String zumov,
//            @Path("id") String id,
//            @Body Objects cancelEventData
//    );

    @POST(URL_LOGIN)
    Call<LoginResponse> postLogin(
            @Body LoginRequest loginRequest);

//    @GET("tables/Users")
//    Call<List<Objects>> getUserProfile();
//
//    // Upload Image and PDF file
//    @Multipart
//    @POST("api/UploadFile")
//    Call<Objects> postImageFile(
//            @Header("accesstoken") String accesstoken,
//            @Header("zumo-api-version") String zumov,
//            @Part("File\"; filename=\"photo.jpg\" ") RequestBody File,
//            @Part("Id") RequestBody Id,
//            @Part("Type") RequestBody Type,
//            @Part("AccessToken") RequestBody AccessToken);

}


