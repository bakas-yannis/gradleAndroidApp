package com.iccs.newgradleandroidapp.interfaces;

import com.android.volley.VolleyError;
import com.iccs.newgradleandroidapp.models.LoginResponse;

/**
 * Created by giannis on 6/2/14.
 */
public interface LoginRequestListener {
    public abstract void onResponse(LoginResponse loginResponse);
    public abstract void onError(VolleyError error);
}