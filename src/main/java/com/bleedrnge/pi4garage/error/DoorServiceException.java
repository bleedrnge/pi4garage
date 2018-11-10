package com.bleedrnge.pi4garage.error;

public class DoorServiceException extends RuntimeException {

    public DoorServiceException() {
        super();
    }

    public DoorServiceException(final String message, final Throwable cause){
        super(message, cause);
    }

    public DoorServiceException(final String message) {
        super(message);
    }

    public DoorServiceException(final Throwable cause) {
        super(cause);
    }
}