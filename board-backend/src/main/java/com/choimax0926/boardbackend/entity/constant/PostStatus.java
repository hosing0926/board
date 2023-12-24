package com.choimax0926.boardbackend.entity.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PostStatus {
    POSTED(0, "게시됨"),
    NOT_POSTED(1, "게시되지 않음"),
    DELETED(2, "삭제됨");

    private int code;
    private String value;
}
