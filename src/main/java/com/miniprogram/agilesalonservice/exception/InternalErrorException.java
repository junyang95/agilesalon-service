package com.miniprogram.agilesalonservice.exception;

public class InternalErrorException extends RuntimeException{

    private static final String DEFAULT_MESSAGE = "内部服务器错误";
    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException() {
        super(DEFAULT_MESSAGE);
    }
}
