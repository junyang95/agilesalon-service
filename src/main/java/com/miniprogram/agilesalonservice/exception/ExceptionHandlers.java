package com.miniprogram.agilesalonservice.exception;

import com.miniprogram.agilesalonservice.dto.ExceptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> GlobalExceptionHandler(Exception e) {
        ExceptionDTO response = new ExceptionDTO();
        if (e instanceof UnauthorizedException) {
            response.setErrorCode(HttpStatus.UNAUTHORIZED.value());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        else if (e instanceof ForbiddenException) {
            response.setErrorCode(HttpStatus.FORBIDDEN.value());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
        else if (e instanceof InternalErrorException) {
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("未知错误,请截图联系客服");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
