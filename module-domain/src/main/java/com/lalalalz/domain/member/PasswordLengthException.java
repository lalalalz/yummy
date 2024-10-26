package com.lalalalz.domain.member;

public class PasswordLengthException extends RuntimeException {
    public PasswordLengthException() {
        super();
    }

    public PasswordLengthException(String message) {
        super(message);
    }

    public PasswordLengthException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordLengthException(Throwable cause) {
        super(cause);
    }
}
