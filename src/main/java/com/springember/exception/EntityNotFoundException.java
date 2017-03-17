package com.springember.exception;

/**
 * Created by aaron.lin on 3/12/17.
 */
public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -5597371741018039691L;
    public EntityNotFoundException(String message) {
        super(message);
    }
}
