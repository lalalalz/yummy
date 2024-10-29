package com.lalalalz.application.port.member;

import com.lalalalz.application.util.BusinessException;

import static com.lalalalz.application.util.ErrorMessage.INVALID_EMAIL;

public class InvalidEmailException extends BusinessException {

    public InvalidEmailException() {
        super(INVALID_EMAIL.getMessage());
    }

    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmailException(Throwable cause) {
        super(cause);
    }
}
