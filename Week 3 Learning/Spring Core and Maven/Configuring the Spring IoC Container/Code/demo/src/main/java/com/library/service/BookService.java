package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for DI
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showAllBooks() {
        System.out.println("BookService: Fetching books...");
        bookRepository.displayBooks();
    }
}