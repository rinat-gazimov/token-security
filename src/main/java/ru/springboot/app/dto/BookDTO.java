package ru.springboot.app.dto;

import lombok.Getter;
import lombok.Setter;
import ru.springboot.app.model.Book;


@Getter @Setter
public class BookDTO {

    private Long bookId;
    private String name;
    private String authorName;

    public BookDTO() {
    }

    public BookDTO(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    public BookDTO (Book book) {
        this.name = book.getName();
        this.authorName = book.getAuthorName();
        this.bookId = book.getId();
    }

}
