package com.iccs.newgradleandroidapp.exceptions;

import java.util.Objects;

/**
 * Created by giannis on 5/29/14.
 */
public class RequestException extends Exception{

    private Objects error;

    public RequestException(Objects error) {
        this.error = error;
    }

    public Objects getError() {
        return this.error;
    }
}
