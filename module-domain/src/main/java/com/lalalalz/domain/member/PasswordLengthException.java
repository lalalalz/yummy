package com.lalalalz.domain.member;

public class PasswordLengthException extends RuntimeException {
    public PasswordLengthException() {
        super("비밀번호 길이가 올바르지 않습니다.");
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
