package com.example.javafx.service;

import com.example.javafx.model.Book;
import com.example.javafx.repository.BookRepository;
import javafx.collections.ObservableList;

public class BookService {
    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public ObservableList<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String isbn, String title, String author, String publisher, int quantity, String description, String imagePath) {
        if (isbn.isEmpty() || title.isEmpty()) {
            throw new IllegalArgumentException("ISBN and Title cannot be empty.");
        }
        // This now calls the constructor with all 7 required arguments
        Book newBook = new Book(isbn, title, author, publisher, quantity, description, imagePath);
        bookRepository.addBook(newBook);
    }
}

