package ru.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springboot.app.model.TokenStatus;

import java.util.UUID;

@Repository
public interface TokenStatusRepository extends CrudRepository<TokenStatus, UUID> {



}
