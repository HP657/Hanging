package com.hp657.hanging.global.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response<T> {
    private int status;
    private T data;

    public Response(HttpStatus status,T data) {
        this.status = status.value();
        this.data = data;
    }
}
