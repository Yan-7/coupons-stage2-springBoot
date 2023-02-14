package com.couponsstage2.exceptions;

public class CouponsExceptions extends Exception{

    public CouponsExceptions() {
        super();
    }

    public CouponsExceptions(String message) {
        super(message);
    }

    public CouponsExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public CouponsExceptions(Throwable cause) {
        super(cause);
    }

    protected CouponsExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
