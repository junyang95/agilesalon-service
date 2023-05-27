package com.miniprogram.agilesalonservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO<T> {
    private Integer code;
    private String message;
    private String timestamp;
    private T data;

    public ResponseDTO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = Instant.now().toString();
    }

    public static <T> ResponseDTO<T> success(String message, T data) {
        return new ResponseDTO<>(0, message, data);
    }

    public static <T> ResponseDTO<T> success(T data) {
        return new ResponseDTO<>(0, "success", data);
    }

    public static <T> ResponseDTO<T> fail(Integer code, String message) {
        return new ResponseDTO<>(code, message, null);
    }

    public static <T> ResponseDTO<T> fail(String message) {
        return new ResponseDTO<>(-1, message, null);
    }

    public static <T> ResponseDTO<T> fail(T data) {
        return new ResponseDTO<>(-1, "fail", null);
    }
}
