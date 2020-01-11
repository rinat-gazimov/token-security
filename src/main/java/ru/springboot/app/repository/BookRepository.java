package ru.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springboot.app.model.Book;

import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<Book, UUID> {



}
