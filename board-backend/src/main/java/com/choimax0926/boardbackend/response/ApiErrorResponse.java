package com.choimax0926.boardbackend.response;

import com.choimax0926.boardbackend.exception.ApiException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApiErrorResponse {

    private int code;

    private String message;

    private String path;

    private LocalDateTime date;

    @Builder
    public ApiErrorResponse(ApiException error, String path) {
        this.code = error.getCode();
        this.message = error.getMessage();
        this.path = path;
        this.date = LocalDateTime.now();
    }
}
