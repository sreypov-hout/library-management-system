package com.example.javafx.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class IssueReturnController {

    // Main containers for the two states
    @FXML private VBox defaultStateContainer;
    @FXML private VBox foundStateContainer;

    // Book Info Card (Found State)
    @FXML private ImageView bookImageView;
    @FXML private Label bookTitleLabel;
    @FXML private Label bookAuthorLabel;
    @FXML private Label bookPublisherLabel;
    @FXML private Label bookQuantityLabel;

    // Borrower Details Form
    @FXML private TextField borrowerNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<String> genderComboBox;

    // Book Details Form
    @FXML private TextField bookIdField;
    @FXML private TextField bookTitleField;
    @FXML private DatePicker issuedDatePicker;
    @FXML private DatePicker returnDatePicker;

    // Success Modal
    @FXML private StackPane successModal;

    @FXML
    public void initialize() {
        // Populate the gender ComboBox with options
        genderComboBox.setItems(FXCollections.observableArrayList("Male", "Female", "Other"));

        // Start in the default state
        showDefaultState();
    }

    @FXML
    private void handleVerifyButton(ActionEvent event) {
        // Simulate a successful verification
        System.out.println("Verify button clicked");
        showSuccessModal();
    }

    @FXML
    private void handleContinueButton(ActionEvent event) {
        successModal.setVisible(false);
        showFoundState();
    }

    @FXML
    private void handleCloseModal(ActionEvent event) {
        successModal.setVisible(false);
    }

    @FXML
    private void handleTakeButton(ActionEvent event) {
        System.out.println("Take button clicked");
        showDefaultState();
    }

    @FXML
    private void handleCancelButton(ActionEvent event) {
        showDefaultState();
    }

    @FXML
    private void handleViewList(ActionEvent event) {
        System.out.println("View List clicked");
        // Logic to navigate to the Borrower List page would go here.
    }

    private void showSuccessModal() {
        successModal.setVisible(true);
    }

    private void showDefaultState() {
        defaultStateContainer.setVisible(true);
        foundStateContainer.setVisible(false);
    }

    private void showFoundState() {
        // In a real application, you would populate the labels here with the actual
        // data found from the database.
        // e.g., bookTitleLabel.setText(foundBook.getTitle());

        defaultStateContainer.setVisible(false);
        foundStateContainer.setVisible(true);
    }
}

