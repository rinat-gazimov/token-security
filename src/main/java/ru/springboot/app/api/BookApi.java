package ru.springboot.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.service.book.BookService;

import java.util.List;

@RestController
public class BookApi {

    @Autowired
    private BookService bookService;

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/book")
    public ResponseEntity getBooks() {

        List<BookDTO> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

}
