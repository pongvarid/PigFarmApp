package com.pitipong.android.pigfarm.api;


import com.pitipong.android.pigfarm.api.request.LoginRequest;
import com.pitipong.android.pigfarm.api.request.PigDataRequest;
import com.pitipong.android.pigfarm.api.response.LoginResponse;
import com.pitipong.android.pigfarm.api.response.PigBreederResponse;
import com.pitipong.android.pigfarm.api.response.PigDataResponse;
import com.pitipong.android.pigfarm.api.response.PigListResponse;

import java.lang.reflect.Array;
import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Header;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import static com.pitipong.android.pigfarm.api.ServiceURL.URL_PIG;
import static com.pitipong.android.pigfarm.api.ServiceURL.URL_LOGIN;
import static com.pitipong.android.pigfarm.api.ServiceURL.URL_PIG_BREEDER;
import static com.pitipong.android.pigfarm.dal.Constant.ACCEPT;
import static com.pitipong.android.pigfarm.dal.Constant.AUTHORIZATION;
import static com.pitipong.android.pigfarm.dal.Constant.CONTENT_TYPE;

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

    @GET(URL_PIG + "/{id}")
    Call<PigDataResponse> getPigData(
            @Header(AUTHORIZATION) String authorization,
            @Header(ACCEPT) String accept,
            @Header(CONTENT_TYPE) String contentType,
            @Path("id") String id);

    @PATCH(URL_PIG + "/{id}")
    Call<PigDataResponse> postPigData(
            @Header(AUTHORIZATION) String authorization,
            @Header(ACCEPT) String accept,
            @Header(CONTENT_TYPE) String contentType,
            @Path("id") String id,
            @Body PigDataRequest pigDataRequest);

    @GET(URL_PIG)
    Call<PigListResponse> getPigList(
            @Header(AUTHORIZATION) String authorization,
            @Header(ACCEPT) String accept,
            @Header(CONTENT_TYPE) String contentType,
            @Query("keyword") String keyword,
            @Query("page") String page
    );

    @GET(URL_PIG + "/{id}/cycles")
    Call<List<PigBreederResponse>> getPigBreeder(
            @Header(AUTHORIZATION) String authorization,
            @Header(ACCEPT) String accept,
            @Header(CONTENT_TYPE) String contentType,
            @Path("id") String id
    );


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


