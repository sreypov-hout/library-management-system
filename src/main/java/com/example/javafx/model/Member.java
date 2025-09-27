package com.example.javafx.model;

import javafx.beans.property.SimpleStringProperty;

public class Member {
    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty email;
    private final SimpleStringProperty phone;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty status;
    private final SimpleStringProperty imagePath;

    public Member(String id, String name, String email, String phone, String gender, String status, String imagePath) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.gender = new SimpleStringProperty(gender);
        this.status = new SimpleStringProperty(status);
        this.imagePath = new SimpleStringProperty(imagePath);
    }

    // Getters and Property Methods
    public String getId() { return id.get(); }
    public SimpleStringProperty idProperty() { return id; }
    public String getName() { return name.get(); }
    public SimpleStringProperty nameProperty() { return name; }
    public String getEmail() { return email.get(); }
    public SimpleStringProperty emailProperty() { return email; }
    public String getPhone() { return phone.get(); }
    public SimpleStringProperty phoneProperty() { return phone; }
    public String getGender() { return gender.get(); }
    public SimpleStringProperty genderProperty() { return gender; }
    public String getStatus() { return status.get(); }
    public SimpleStringProperty statusProperty() { return status; }
    public String getImagePath() { return imagePath.get(); }
    public SimpleStringProperty imagePathProperty() { return imagePath; }
}

