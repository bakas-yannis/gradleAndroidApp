package com.iccs.newgradleandroidapp.models;

/**
 * Created by giannis on 5/28/14.
 */

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("session")
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public LoginResponse(String session) {
        this.session = session;
    }

}
