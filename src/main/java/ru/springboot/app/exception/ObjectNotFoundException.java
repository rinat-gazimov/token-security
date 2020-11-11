package ru.springboot.app.exception;

public class ObjectNotFoundException extends Exception {

    private String message;

    public ObjectNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
