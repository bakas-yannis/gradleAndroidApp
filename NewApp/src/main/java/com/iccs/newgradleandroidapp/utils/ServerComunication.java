package com.iccs.newgradleandroidapp.utils;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.GsonBuilder;
import com.iccs.newgradleandroidapp.interfaces.LoginRequestListener;
import com.iccs.newgradleandroidapp.models.LoginResponse;

import java.io.UnsupportedEncodingException;

/**
 * Created by giannis on 6/2/14.
 */
public class ServerComunication {

    private LoginRequestListener mLoginRequestListener = null;

    public void setLoginListener(LoginRequestListener loginRequestListener){
        this.mLoginRequestListener = loginRequestListener;
    }

    public void login(){

        String url = "http://broadbit.com:8080/rest-api/identity.json/login?id=iccs-vehicle-one&password=11a92f75e0460e95218a6d85b76bc02b";

        Request request = new JsonRequest<LoginResponse>(Request.Method.GET, url, null, new Response.Listener<LoginResponse>() {

            @Override
            public void onResponse(LoginResponse response) {
                mLoginRequestListener.onResponse(response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                mLoginRequestListener.onError(error);
            }
        }) {

            @Override
            protected Response<LoginResponse> parseNetworkResponse(NetworkResponse response) {
                String jsonString = null;
                try {
                    jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                } catch (UnsupportedEncodingException e) {
                }
                LoginResponse person = new GsonBuilder().create().fromJson(jsonString, LoginResponse.class);
                Response<LoginResponse> result = Response.success(person, HttpHeaderParser.parseCacheHeaders(response));
                return result;
            }
        };

        ApplicationController.getInstance().addToRequestQueue(request,"LOGIN");

    }


}
