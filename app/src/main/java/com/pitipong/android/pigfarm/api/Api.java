package com.pitipong.android.pigfarm.api;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import static com.pitipong.android.pigfarm.api.ServiceURL.URL_BASE;


/**
 * Created by pw on 1/27/2017 AD.
 */

public class Api {

    private static Api instance = null;
    private Map<String, String> headers = new HashMap<String, String>();
    private ApiEndPointsService service;
    private Context context;
    private Retrofit retrofit;

    public static String accesstoken;

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    /**
     * public constructor
     */
    private Api(Context context) {
        this.context = context;
    }

    /**
     * Get the HttpApi singleton instance
     */
    public static Api getInstance(Context context) {
        if (instance == null) {
            instance = new Api(context);
            instance.initializeApiClient();
        }
        return instance;
    }

    /**
     * Get the API service to execute calls with
     */

    public ApiEndPointsService getService() {
        return service;
    }

    private void initializeApiClient() {
        // OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);

        // Cookie
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        okHttpClient.setCookieHandler(cookieManager);

        // Logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(interceptor);

        // Add header
//        okHttpClient.networkInterceptors().add(new Interceptor() {
//            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
//                Request.Builder builder = chain.request().newBuilder();
//                for (Map.Entry<String, String> entry : headers.entrySet()) {
//                    builder.addHeader(entry.getKey(), entry.getValue());
//                }
//                return chain.proceed(builder.build());
//            }
//        });

        // Retrofit setup
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Service setup
        service = retrofit.create(ApiEndPointsService.class);
    }

    public void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }


}

