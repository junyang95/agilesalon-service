package com.miniprogram.agilesalonservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ExceptionDTO {
    private Integer errorCode;
    private String traceId;
    private String message;
    private String timestamp;

    public ExceptionDTO() {
        this.traceId = UUID.randomUUID().toString();
        this.timestamp = Instant.now().toString();
    }

    public ExceptionDTO(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.traceId = UUID.randomUUID().toString();
        this.message = message;
        this.timestamp = Instant.now().toString();
    }

}
