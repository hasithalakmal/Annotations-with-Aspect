package com.smile24es.sample.exception;

import org.springframework.http.HttpStatus;

public class Smile24Exception extends Exception {

    private static final long serialVersionUID = 3078289635627866758L;

    private final HttpStatus httpStatusCode;
    private final String errorCode;

    public Smile24Exception(HttpStatus httpStatusCode, String errorCode, String message, Throwable t) {
        super(message, t);
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }

    public Smile24Exception(HttpStatus httpStatusCode, String errorCode, String message) {
        this(httpStatusCode, errorCode, message, null);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
