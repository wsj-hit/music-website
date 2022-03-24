package com.example.yin.common;

import org.springframework.http.HttpStatus;

public record Result<T>(int code, String msg, T data) {

    public static <T> Result<T> success(T data) {
        return new Result<>(HttpStatus.OK.value(), "success", data);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg, null);
    }

    public static Result<?> success() {
        return success(null);
    }
}
