package com.example.javafx.model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Book {
    private StringProperty isbn;
    private StringProperty title;
    private StringProperty author;
    private StringProperty publisher;
    private IntegerProperty quantity;
    private StringProperty description;
    private StringProperty imagePath;
    private ObjectProperty<Image> image = new SimpleObjectProperty<>();

    public Book(String isbn, String title, String author, String publisher, int quantity, String description, String imagePath) {
        this.isbn = new SimpleStringProperty(isbn);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.description = new SimpleStringProperty(description);
        this.imagePath = new SimpleStringProperty(imagePath);
    }

    public String getIsbn() { return isbn.get(); }
    public StringProperty isbnProperty() { return isbn; }

    public String getTitle() { return title.get(); }
    public StringProperty titleProperty() { return title; }

    public String getAuthor() { return author.get(); }
    public StringProperty authorProperty() { return author; }

    public String getPublisher() { return publisher.get(); }
    public StringProperty publisherProperty() { return publisher; }

    public int getQuantity() { return quantity.get(); }
    public IntegerProperty quantityProperty() { return quantity; }

    public String getDescription() { return description.get(); }
    public StringProperty descriptionProperty() { return description; }

    public String getImagePath() { return imagePath.get(); }
    public void setImagePath(String path) { this.imagePath.set(path); }
    public StringProperty imagePathProperty() { return imagePath; }

    public Image getImage() { return image.get(); }
    public void setImage(Image img) { this.image.set(img); }
    public ObjectProperty<Image> imageProperty() { return image; }

    public String getStatus() {
        return getQuantity() > 0 ? "Available" : "Unavailable";
    }
    public StringProperty statusProperty() {
        return new SimpleStringProperty(getStatus());
    }
}
