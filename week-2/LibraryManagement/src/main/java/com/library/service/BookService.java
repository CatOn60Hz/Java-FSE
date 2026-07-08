package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    private BookRepository bookRepository;

    // Setter for Dependency Injection (Exercise 2)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBook() {
        System.out.println("Managing book...");
        if (bookRepository != null) {
            bookRepository.save();
        } else {
            System.out.println("BookRepository is not injected.");
        }
    }
}
