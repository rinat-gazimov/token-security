package ru.springboot.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.dto.ErrorResponse;
import ru.springboot.app.exception.ObjectNotFoundException;
import ru.springboot.app.model.Book;
import ru.springboot.app.service.book.BookService;

import java.util.List;

@RestController
public class BookApi {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity getBooks(
            @RequestParam(value = "authorName", required = false) String authorName,
            @RequestParam(value = "bookName", required = false) String bookName) {
        List<BookDTO> books = bookService.getBooks(authorName, bookName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity saveBook(@RequestBody BookDTO bookDTO) {
        try {
            Long id = bookService.saveBook(bookDTO);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("internal server error"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/book")
    public ResponseEntity deleteBook(@RequestParam(value = "id", required = true) Long id) {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("internal server error"), HttpStatus.BAD_REQUEST);
        }
    }

}
