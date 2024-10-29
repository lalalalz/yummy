package com.lalalalz.application.port.member;

import com.lalalalz.application.util.BusinessException;

import static com.lalalalz.application.util.ErrorMessage.DUPLICATED_EMAIL;

public class DuplicatedEmailException extends BusinessException {
    public DuplicatedEmailException() {
        super(DUPLICATED_EMAIL.getMessage());
    }

    public DuplicatedEmailException(String message) {
        super(message);
    }

    public DuplicatedEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedEmailException(Throwable cause) {
        super(cause);
    }
}
