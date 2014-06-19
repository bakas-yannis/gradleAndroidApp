package com.iccs.newgradleandroidapp.utils;

import android.content.Context;
import com.android.volley.*;
import com.iccs.newgradleandroidapp.newapp.R;


public class VolleyErrorHelper {

    /**
     * Returns appropriate message which is to be displayed to the user
     * against the specified error object.
     *
     * @param error
     * @param context
     * @return
     */
    public static String getMessage(Object error, Context context) {

        VolleyError err = (VolleyError) error;

        String response = err.getMessage();

        if (error instanceof TimeoutError) {
            return context.getResources().getString(R.string.generic_server_down);
        }
        else if (isServerProblem(error)) {
            return handleServerError(error, context);
        }
        else if (response.contains("authentication")){
            return context.getResources().getString(R.string.unauthorized);
        }
        else if (response.contains("Connection refused")){
            return context.getResources().getString(R.string.generic_server_down);
        }
        else {
            if (isNetworkProblem(error)) {
                return context.getResources().getString(R.string.no_internet);
            }
        }

        return context.getResources().getString(R.string.generic_error);
    }

    /**
     * Determines whether the error is related to network
     * @param error
     * @return
     */
    private static boolean isNetworkProblem(Object error) {
        return (error instanceof NetworkError) || (error instanceof NoConnectionError);
    }
    /**
     * Determines whether the error is related to server
     * @param error
     * @return
     */
    private static boolean isServerProblem(Object error) {
        return (error instanceof ServerError) || (error instanceof AuthFailureError) || (error instanceof TimeoutError);
    }
    /**
     * Handles the server error, tries to determine whether to show a stock message or to
     * show a message retrieved from the server.
     *
     * @param err
     * @param context
     * @return
     */
    private static String handleServerError(Object err, Context context) {
        VolleyError error = (VolleyError) err;

        NetworkResponse response = error.networkResponse;

        if (response != null) {
            switch (response.statusCode) {
                case 404:
                case 422:
                case 401:
                    // Unauthorized user
                    return context.getResources().getString(R.string.unauthorized);
                default:
                    return context.getResources().getString(R.string.generic_server_down);
            }
        }
        return context.getResources().getString(R.string.generic_error);
    }
}

