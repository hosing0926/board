package com.choimax0926.boardbackend.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {
    private int code;
    private String message;

    public ApiException(Error error) {
        this.code = error.getCode();
        this.message = error.getMessage();
    }
}
