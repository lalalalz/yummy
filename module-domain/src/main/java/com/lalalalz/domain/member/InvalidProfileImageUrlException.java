package com.lalalalz.domain.member;

public class InvalidProfileImageUrlException extends RuntimeException {
    public InvalidProfileImageUrlException() {
    }

    public InvalidProfileImageUrlException(String message) {
        super(message);
    }

    public InvalidProfileImageUrlException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidProfileImageUrlException(Throwable cause) {
        super(cause);
    }

    public InvalidProfileImageUrlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
