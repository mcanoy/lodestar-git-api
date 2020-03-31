package com.redhat.labs.exception;

public class UnexpectedGitLabResponseException extends Exception {

    private static final long serialVersionUID = -2450016825084220551L;

    public UnexpectedGitLabResponseException() {
        super();
    }

    public UnexpectedGitLabResponseException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UnexpectedGitLabResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedGitLabResponseException(String message) {
        super(message);
    }

    public UnexpectedGitLabResponseException(Throwable cause) {
        super(cause);
    }

}
