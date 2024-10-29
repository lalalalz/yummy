package com.lalalalz.web.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBody<T> {
    
    private T body;
    private String message;

    public static <R> ResponseBody<R> ok(R body) {
        return new ResponseBody<>(body, "성공");
    }

    public static <R> ResponseBody<R> ok(R body, String message) {
        return new ResponseBody<>(body, message);
    }
}
