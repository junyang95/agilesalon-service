package com.miniprogram.agilesalonservice.exception;

public class UnauthorizedException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "用户未授权";
    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException() {
        super(DEFAULT_MESSAGE);
    }
}
