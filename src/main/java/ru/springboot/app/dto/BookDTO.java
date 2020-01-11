package ru.springboot.app.dto;

import ru.springboot.app.model.Book;

public class BookDTO {

    private String name;
    private String authorName;

    public BookDTO(String name, String authorName) {
        this.name = name;
        this.authorName = authorName;
    }

    public BookDTO (Book book) {
        this.name = book.getName();
        this.authorName = book.getAuthorName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
