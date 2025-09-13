package com.example.javafx.repository;

import com.example.javafx.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookRepository {
    private final ObservableList<Book> books = FXCollections.observableArrayList();

    public BookRepository() {
        // Sample data now includes publisher, description, and image path
        books.add(new Book("987-377-39", "The 48 Laws of Power", "Robert Greene", "2004", 4, "Power is a book within a book", ""));
        books.add(new Book("01", "Follow your heart", "Andrew Matthews", "2003", 3, "Description here", ""));
        books.add(new Book("03", "Book Six", "MOEY", "2016", 0, "Description here", ""));
    }

    public ObservableList<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}

