package ru.springboot.app.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;

@Getter @Setter
public class UserDetailsDTO {

    private String email;


    public UserDetailsDTO(Authentication authentication) {

        int a = 0;

    }
}
