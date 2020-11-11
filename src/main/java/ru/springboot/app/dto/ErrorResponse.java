package ru.springboot.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse {

    private int code;
    private String message;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ErrorResponse(String message) {
        this.message = message;
    }
}
