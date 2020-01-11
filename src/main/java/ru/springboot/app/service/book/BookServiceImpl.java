package ru.springboot.app.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.model.Book;
import ru.springboot.app.repository.BookRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getBooks() {

        List<Book> books = (List<Book>) bookRepository.findAll();
        List<BookDTO> booksDTO = books.stream().map(BookDTO::new).collect(Collectors.toList());

        return booksDTO;
    }
}
