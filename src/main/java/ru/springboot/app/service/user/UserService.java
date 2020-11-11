package ru.springboot.app.service.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.springboot.app.dto.TokenDTO;
import ru.springboot.app.dto.UserDTO;
import ru.springboot.app.dto.UserDetailsDTO;
import ru.springboot.app.repository.TokensRepository;


@Service
public interface UserService {

    TokenDTO login(UserDTO userDTO);

    Long register(UserDTO userDTO);

    UserDetailsDTO userDetails();
}
