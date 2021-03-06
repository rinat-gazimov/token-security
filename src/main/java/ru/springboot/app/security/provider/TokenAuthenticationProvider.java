package ru.springboot.app.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.springboot.app.exception.InvalidTokenException;
import ru.springboot.app.model.Token;
import ru.springboot.app.repository.TokensRepository;
import ru.springboot.app.security.token.TokenAuthentication;
import ru.springboot.app.utils.DataConstants;

import java.util.Optional;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;

        Optional<Token> tokenCandidate = tokensRepository.findOneByValue(tokenAuthentication.getName());

        if (tokenCandidate.isPresent()) {
            if (tokenCandidate.get().getTokenStatus().getId().equals(DataConstants.TokenStatus.ACTIVE.getValue())) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getUser().getEmail());
                tokenAuthentication.setUserDetails(userDetails);
                tokenAuthentication.setAuthenticated(true);
                return tokenAuthentication;
            } else throw new IllegalArgumentException("Token expired");

        } else throw new IllegalArgumentException("Invalid token");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return TokenAuthentication.class.equals(authentication);
    }
}
