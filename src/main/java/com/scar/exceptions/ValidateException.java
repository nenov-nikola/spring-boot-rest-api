package com.scar.exceptions;

/**
 * Created by nikola on 3/26/17.
 */

public class ValidateException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Exception e) {
        super(message, e);
    }
}
