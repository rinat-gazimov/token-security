package ru.springboot.app.exception;

public class InvalidTokenException extends Exception {

    private String message;

    public InvalidTokenException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
