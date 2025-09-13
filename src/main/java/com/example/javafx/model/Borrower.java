package com.example.javafx.model;

import javafx.beans.property.SimpleStringProperty;

public class Borrower {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty book;
    private final SimpleStringProperty issueDate;
    private final SimpleStringProperty returnDate;

    public Borrower(String id, String name, String phone, String gender, String book, String issueDate, String returnDate) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.phone = new SimpleStringProperty(phone);
        this.gender = new SimpleStringProperty(gender);
        this.book = new SimpleStringProperty(book);
        this.issueDate = new SimpleStringProperty(issueDate);
        this.returnDate = new SimpleStringProperty(returnDate);
    }

    // --- Getters and Property Methods ---
    public String getId() { return id.get(); }
    public SimpleStringProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public SimpleStringProperty nameProperty() { return name; }

    public String getPhone() { return phone.get(); }
    public SimpleStringProperty phoneProperty() { return phone; }

    public String getGender() { return gender.get(); }
    public SimpleStringProperty genderProperty() { return gender; }

    public String getBook() { return book.get(); }
    public SimpleStringProperty bookProperty() { return book; }

    public String getIssueDate() { return issueDate.get(); }
    public SimpleStringProperty issueDateProperty() { return issueDate; }

    public String getReturnDate() { return returnDate.get(); }
    public SimpleStringProperty returnDateProperty() { return returnDate; }
}
