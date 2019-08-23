package com.post.cloud.state.machine;public class StateException extends RuntimeException {
    private static final long serialVersionUID = 9220581907917573972L;

    public StateException() {
        super();
    }

    public StateException(String message) {
        super(message);
    }

    public StateException(String message, Throwable cause) {
        super(message, cause);
    }

    public StateException(Throwable cause) {
        super(cause);
    }
}
