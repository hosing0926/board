package com.choimax0926.boardbackend.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {

    private Object data;

    private Integer code;

    private String message;

    @Builder
    public ApiResponse(Object data) {
        if (data != null) {
            this.code = 0;
            this.message = "success";
        }

        this.data = data;
    }
}
