package com.lalalalz.application.port.member;

import com.lalalalz.application.util.BusinessException;

public class UploadProfileException extends BusinessException {

    public UploadProfileException() {
    }

    public UploadProfileException(String message) {
        super(message);
    }

    public UploadProfileException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadProfileException(Throwable cause) {
        super(cause);
    }
}
