package com.api.springboot.services.exceptions;


public class ObjectNotFoundException extends  RuntimeException {

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
