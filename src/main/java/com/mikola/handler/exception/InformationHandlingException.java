package com.mikola.handler.exception;

public class InformationHandlingException extends Exception {
    public InformationHandlingException(String message) {
        super(message);
    }

    public InformationHandlingException(String message, Exception cause) {
        super(message, cause);
    }

    public InformationHandlingException(Throwable cause) {
        super(cause);
    }
}
