package ru.springboot.app.service.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.springboot.app.model.Book;
import ru.springboot.app.repository.BookRepository;

import javax.sql.DataSource;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;


    @Test
    public void whenFindByAuthorName_thenReturnBook() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setAuthorName("Пушкин");
        entityManager.persist(book);
        entityManager.flush();
        List<Book> books = (List<Book>)bookRepository.findAllByNameAndAuthorName(book.getName(), book.getAuthorName());
        assertThat(books.get(0).getAuthorName()).isEqualTo(book.getAuthorName());
    }

}
