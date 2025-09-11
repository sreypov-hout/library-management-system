package com.yourlibrary.repository;

import com.yourlibrary.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookRepository {
    // Using an ObservableList to allow the TableView to update automatically
    private final ObservableList<Book> books = FXCollections.observableArrayList();

    public BookRepository() {
        // Add some sample data
        books.add(new Book("978-0321765723", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 5, ""));
        books.add(new Book("978-0743273565", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 3, ""));
    }

    public ObservableList<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    // In a real app, you would add update() and delete() methods here
}