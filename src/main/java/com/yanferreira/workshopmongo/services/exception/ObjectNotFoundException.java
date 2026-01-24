package com.yanferreira.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ObjectNotFoundException (String msg) {
        super(msg);
    }
}
