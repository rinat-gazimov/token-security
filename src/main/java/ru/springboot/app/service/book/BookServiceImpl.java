package ru.springboot.app.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.springboot.app.dto.BookDTO;
import ru.springboot.app.exception.ObjectNotFoundException;
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
    public List<BookDTO> getBooks(String authorName, String bookName) {
        List<Book> books = (List<Book>) bookRepository.findAllByNameAndAuthorName(bookName, authorName);
        List<BookDTO> booksDTO = books.stream().map(BookDTO::new).collect(Collectors.toList());
        return booksDTO;
    }

    @Override
    public Long saveBook(BookDTO bookDTO) throws ObjectNotFoundException {

        Book book;

        if (bookDTO.getBookId() != null) {
            book = bookRepository.findOne(bookDTO.getBookId());
            if (book == null)
                throw new ObjectNotFoundException("Book with id " + bookDTO.getBookId() + " not found");
        } else
            book = new Book();

        book.setAuthorName(bookDTO.getAuthorName());
        book.setName(bookDTO.getName());
        book = bookRepository.save(book);

        return book.getId();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}
