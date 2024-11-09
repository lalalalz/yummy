package com.lalalalz.domain.member;

public class SamePasswordException extends RuntimeException {

    public SamePasswordException() {
        super("동일한 비밀번호로 변경하였습니다.");
    }

    public SamePasswordException(String message) {
        super(message);
    }

    public SamePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public SamePasswordException(Throwable cause) {
        super(cause);
    }

    public SamePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
