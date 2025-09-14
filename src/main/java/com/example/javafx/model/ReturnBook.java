package com.example.javafx.model;

import javafx.beans.property.SimpleStringProperty;

public class ReturnBook {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty bookTitle;
    private final SimpleStringProperty issueDate;
    private final SimpleStringProperty returnDate;
    private final SimpleStringProperty author;
    private final SimpleStringProperty publisher;
    private final SimpleStringProperty quantity;
    private final SimpleStringProperty imagePath;

    public ReturnBook(String id, String name, String phone, String gender, String bookTitle, String issueDate, String returnDate, String author, String publisher, String quantity, String imagePath) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.gender = new SimpleStringProperty(gender);
        this.bookTitle = new SimpleStringProperty(bookTitle);
        this.issueDate = new SimpleStringProperty(issueDate);
        this.returnDate = new SimpleStringProperty(returnDate);
        this.author = new SimpleStringProperty(author);
        this.publisher = new SimpleStringProperty(publisher);
        this.quantity = new SimpleStringProperty(quantity);
        this.imagePath = new SimpleStringProperty(imagePath);
    }

    // Getters and Property Methods
    public String getId() { return id.get(); }
    public SimpleStringProperty idProperty() { return id; }
    public String getName() { return name.get(); }
    public SimpleStringProperty nameProperty() { return name; }
    public String getPhone() { return phone.get(); }
    public SimpleStringProperty phoneProperty() { return phone; }
    public String getGender() { return gender.get(); }
    public SimpleStringProperty genderProperty() { return gender; }
    public String getBookTitle() { return bookTitle.get(); }
    public SimpleStringProperty bookTitleProperty() { return bookTitle; }
    public String getIssueDate() { return issueDate.get(); }
    public SimpleStringProperty issueDateProperty() { return issueDate; }
    public String getReturnDate() { return returnDate.get(); }
    public SimpleStringProperty returnDateProperty() { return returnDate; }
    public String getAuthor() { return author.get(); }
    public SimpleStringProperty authorProperty() { return author; }
    public String getPublisher() { return publisher.get(); }
    public SimpleStringProperty publisherProperty() { return publisher; }
    public String getQuantity() { return quantity.get(); }
    public SimpleStringProperty quantityProperty() { return quantity; }
    public String getImagePath() { return imagePath.get(); }
    public SimpleStringProperty imagePathProperty() { return imagePath; }
}
