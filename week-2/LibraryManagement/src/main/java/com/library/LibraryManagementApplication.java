package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        // Load the Spring context (Exercise 1)
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Test configuration and dependency injection (Exercise 1 & 2)
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.manageBook();
    }
}
