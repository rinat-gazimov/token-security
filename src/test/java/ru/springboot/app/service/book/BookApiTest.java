package ru.springboot.app.service.book;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.springboot.app.api.BookApi;
import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.model.Book;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApiTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookApi bookApi;

    @Test
    public void testGetBooks() {
        Book book = new Book();
        book.setId(3L);

        ResponseEntity<Book> res = bookApi.getBooks(null, null);
        Assert.assertEquals(((List<Book>)res.getBody()).get(0).getId(), book.getId());


    }




}
