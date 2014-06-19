package com.iccs.newgradleandroidapp.requests;

/**
 * Created by giannis on 5/29/14.
 */
public class LoginRequest {

    private static final String PATH = "/identity.json/login?";
    private static final String ID = "id=";
    private static final String PASS = "password=";

    public static String getURL(String domain, String id, String pass){

        return domain+PATH+ID+id+"&"+PASS+pass;

    }


}
