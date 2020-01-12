package ru.springboot.app.service.user;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.springboot.app.dto.TokenDTO;
import ru.springboot.app.dto.UserDTO;
import ru.springboot.app.model.Role;
import ru.springboot.app.model.State;
import ru.springboot.app.model.Token;
import ru.springboot.app.model.User;
import ru.springboot.app.repository.TokenStatusRepository;
import ru.springboot.app.repository.TokensRepository;
import ru.springboot.app.repository.UserRepository;
import ru.springboot.app.utils.DataConstants;

import java.util.Optional;
import java.util.UUID;

import static ru.springboot.app.dto.TokenDTO.from;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenStatusRepository tokenStatusRepository;


    @Override
    public TokenDTO login(UserDTO userDTO) {
        Optional<User> userCandidate = userRepository.findUserByEmail(userDTO.getEmail());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();

            if (passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
                Token token = new Token();
                token.setUser(user);
                token.setValue(RandomStringUtils.random(10, true, true));
                token.setTokenStatus(tokenStatusRepository.findOne(DataConstants.TokenStatus.ACTIVE.getValue()));

                tokensRepository.save(token);
                return from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }

    @Override
    public UUID register(UserDTO userDTO) {

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.USER);
        user.setState(State.ACTIVE);

        userRepository.save(user);

        return user.getId();
    }
}
