package com.lalalalz.domain.member;

public class ChangePasswordToSamePasswordException extends RuntimeException {

    public ChangePasswordToSamePasswordException() {
    }

    public ChangePasswordToSamePasswordException(String message) {
        super(message);
    }

    public ChangePasswordToSamePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangePasswordToSamePasswordException(Throwable cause) {
        super(cause);
    }

    public ChangePasswordToSamePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
