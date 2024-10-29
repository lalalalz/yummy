package com.lalalalz.application.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorMessage {

    DUPLICATED_EMAIL("이메일이 중복 입니다."),
    INVALID_EMAIL("유효하지 않은 이메일 입니다."),
    ;

    private String message;
}
