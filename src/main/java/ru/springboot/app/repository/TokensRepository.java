package ru.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springboot.app.model.Token;
import ru.springboot.app.model.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokensRepository extends CrudRepository<Token, UUID> {

    Optional<Token> findOneByValue(String value);

}
