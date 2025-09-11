package com.yourlibrary.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private final SimpleStringProperty isbn;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleStringProperty genre;
    private final SimpleIntegerProperty quantity;
    private final SimpleStringProperty imagePath;

    public Book(String isbn, String title, String author, String genre, int quantity, String imagePath) {
        this.isbn = new SimpleStringProperty(isbn);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.genre = new SimpleStringProperty(genre);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.imagePath = new SimpleStringProperty(imagePath);
    }

    // --- Getters for JavaFX Properties ---
    public String getIsbn() { return isbn.get(); }
    public SimpleStringProperty isbnProperty() { return isbn; }
    public String getTitle() { return title.get(); }
    public SimpleStringProperty titleProperty() { return title; }
    public String getAuthor() { return author.get(); }
    public SimpleStringProperty authorProperty() { return author; }
    public String getGenre() { return genre.get(); }
    public SimpleStringProperty genreProperty() { return genre; }
    public int getQuantity() { return quantity.get(); }
    public SimpleIntegerProperty quantityProperty() { return quantity; }
    public String getImagePath() { return imagePath.get(); }
    public SimpleStringProperty imagePathProperty() { return imagePath; }
}