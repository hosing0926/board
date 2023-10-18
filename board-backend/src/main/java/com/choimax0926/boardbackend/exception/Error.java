package com.choimax0926.boardbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Error {
    ;

    private final int code;
    private final String message;
}
