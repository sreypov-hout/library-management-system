package com.yourlibrary.service;

import com.yourlibrary.model.Book;
import com.yourlibrary.repository.BookRepository;
import javafx.collections.ObservableList;

public class BookService {
    private final BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public ObservableList<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void addBook(String isbn, String title, String author, String genre, int quantity, String imagePath) {
        // Business logic can go here (e.g., check if ISBN already exists)
        if (isbn.isEmpty() || title.isEmpty()) {
            throw new IllegalArgumentException("ISBN and Title cannot be empty.");
        }
        Book newBook = new Book(isbn, title, author, genre, quantity, imagePath);
        bookRepository.addBook(newBook);
    }
}