package ru.springboot.app.service.book;

import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.model.Book;

import java.util.List;

public interface BookService {

    List<BookDTO> getBooks();

}
