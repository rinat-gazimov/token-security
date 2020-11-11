package ru.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springboot.app.model.TokenStatus;


@Repository
public interface TokenStatusRepository extends CrudRepository<TokenStatus, Long> {



}
