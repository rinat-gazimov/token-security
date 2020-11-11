package ru.springboot.app.repository;

import org.kolobok.annotation.FindWithOptionalParams;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.springboot.app.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @FindWithOptionalParams
    Iterable<Book> findAllByNameAndAuthorName(String name, String authorName);
}
