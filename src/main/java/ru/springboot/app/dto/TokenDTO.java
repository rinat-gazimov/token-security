package ru.springboot.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.springboot.app.model.Token;

public class TokenDTO {

    private String value;

    public TokenDTO(String value) {
        this.value = value;
    }

    public static TokenDTO from(Token token) {
        return new TokenDTO(token.getValue());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
