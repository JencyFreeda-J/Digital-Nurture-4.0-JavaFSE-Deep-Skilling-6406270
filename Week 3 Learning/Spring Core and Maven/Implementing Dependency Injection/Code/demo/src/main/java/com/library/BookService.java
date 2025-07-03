package com.library;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("Setter injection used");
    }

    public void addBook(String bookName) {
        bookRepository.save(bookName);
    }
}