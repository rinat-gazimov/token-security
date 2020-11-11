package ru.springboot.app.service.book;

import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.exception.ObjectNotFoundException;
import ru.springboot.app.model.Book;

import java.util.List;

public interface BookService {

    List<BookDTO> getBooks(String authorName, String bookName);

    Long saveBook(BookDTO bookDTO) throws ObjectNotFoundException;

    void deleteBook(Long id);
}