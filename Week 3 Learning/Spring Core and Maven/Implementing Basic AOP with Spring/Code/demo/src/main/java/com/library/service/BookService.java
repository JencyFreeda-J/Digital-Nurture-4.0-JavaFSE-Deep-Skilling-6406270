package com.library.service;

import org.springframework.stereotype.Component;

@Component
public class BookService {

    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
    }

    public void removeBook(String bookName) {
        System.out.println("Removing book: " + bookName);
    }
}