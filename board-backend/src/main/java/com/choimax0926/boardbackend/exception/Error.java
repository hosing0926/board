package com.choimax0926.boardbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {

    EMPTY_PARAM(1000, "empty param")
    ;

    private final int code;
    private final String message;
}
