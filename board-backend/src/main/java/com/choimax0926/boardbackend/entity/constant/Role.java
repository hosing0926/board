package com.choimax0926.boardbackend.entity.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    USER("user"),
    ADMIN("admin");

    private String value;
}
