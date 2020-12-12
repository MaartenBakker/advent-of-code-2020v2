package com.maartenmusic.day5;

public class SeatNotFoundError extends RuntimeException {
    public SeatNotFoundError() {
        super();
    }

    public SeatNotFoundError(String message) {
        super(message);
    }

    public SeatNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public SeatNotFoundError(Throwable cause) {
        super(cause);
    }

    protected SeatNotFoundError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
