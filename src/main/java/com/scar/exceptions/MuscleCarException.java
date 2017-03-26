package com.scar.exceptions;

/**
 * Created by nikola on 3/26/17.
 */

public class MuscleCarException extends Exception{

    private static final long serialVersionUID = 1L;

    public MuscleCarException(String message) {
        super(message);
    }

    public MuscleCarException(String message, Exception e) {
        super(message, e);
    }
}
