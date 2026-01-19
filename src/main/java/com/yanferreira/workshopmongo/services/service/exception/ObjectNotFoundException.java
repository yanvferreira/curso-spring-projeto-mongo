package com.yanferreira.workshopmongo.services.service.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ObjectNotFoundException (String msg) {
        super(msg);
    }
}
