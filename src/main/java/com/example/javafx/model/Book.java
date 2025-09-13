package com.example.javafx.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private final SimpleStringProperty isbn;
    private final SimpleStringProperty title;
    private final SimpleStringProperty author;
    private final SimpleStringProperty publisher;
    private final SimpleIntegerProperty quantity;
    private final SimpleStringProperty description;
    private final SimpleStringProperty imagePath;
    private final SimpleStringProperty status;

    public Book(String isbn, String title, String author, String publisher, int quantity, String description, String imagePath) {
        this.isbn = new SimpleStringProperty(isbn);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.description = new SimpleStringProperty(description);
        this.imagePath = new SimpleStringProperty(imagePath);
        this.status = new SimpleStringProperty(quantity > 0 ? "Available" : "Unavailable");
    }

    // --- Getters and Property Methods ---
    public String getIsbn() { return isbn.get(); }
    public SimpleStringProperty isbnProperty() { return isbn; }

    public String getTitle() { return title.get(); }
    public SimpleStringProperty titleProperty() { return title; }

    public String getAuthor() { return author.get(); }
    public SimpleStringProperty authorProperty() { return author; }

    public String getPublisher() { return publisher.get(); }
    public SimpleStringProperty publisherProperty() { return publisher; }

    public int getQuantity() { return quantity.get(); }
    public SimpleIntegerProperty quantityProperty() { return quantity; }

    public String getDescription() { return description.get(); }
    public SimpleStringProperty descriptionProperty() { return description; }

    public String getImagePath() { return imagePath.get(); }
    public SimpleStringProperty imagePathProperty() { return imagePath; }

    public String getStatus() { return status.get(); }
    public SimpleStringProperty statusProperty() { return status; }
}

