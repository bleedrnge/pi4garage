package com.bleedrnge.pi4garage.error;

public class AccessLogServiceException extends RuntimeException {

    public AccessLogServiceException() {
        super();
    }

    public AccessLogServiceException(final String message, final Throwable cause){
        super(message, cause);
    }

    public AccessLogServiceException(final String message) {
        super(message);
    }

    public AccessLogServiceException(final Throwable cause) {
        super(cause);
    }
}