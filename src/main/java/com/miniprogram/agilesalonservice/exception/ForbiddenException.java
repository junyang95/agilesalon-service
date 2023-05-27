package com.miniprogram.agilesalonservice.exception;

public class ForbiddenException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "禁止访问";
    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException() {
        super(DEFAULT_MESSAGE);
    }
}
