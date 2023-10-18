package com.choimax0926.boardbackend.exception;

import com.choimax0926.boardbackend.response.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiErrorResponse> handleException(HttpServletRequest request, ApiException error) {
        log.error("error [code: {}, message:{}, path:{}]", error.getCode(), error.getMessage(), request.getRequestURI());

        return ResponseEntity.ok(ApiErrorResponse.builder()
                .error(error)
                .path(request.getRequestURI())
                .build());
    }
}
