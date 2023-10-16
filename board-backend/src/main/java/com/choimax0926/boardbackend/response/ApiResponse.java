package com.choimax0926.boardbackend.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse {

    private Object data;

    private Integer code;

    private String message;

    private LocalDateTime date;

    @Builder
    public ApiResponse(Object data, Integer code, String message) {
        if (data != null) {
            code = 0;
            message = "success";
        }

        this.data = data;
        this.code = code;
        this.message = message;
        this.date = LocalDateTime.now();
    }
}
