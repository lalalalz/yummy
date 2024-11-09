package com.lalalalz.application.port.member.out;

import com.lalalalz.application.util.BusinessException;

public class ChangePasswordException extends BusinessException {

    public ChangePasswordException() {
    }

    public ChangePasswordException(String message) {
        super(message);
    }

    public ChangePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChangePasswordException(Throwable cause) {
        super(cause);
    }
}
