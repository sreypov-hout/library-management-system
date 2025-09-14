package com.example.javafx.controller;

import com.example.javafx.model.ReturnBook;
import com.example.javafx.service.ReturnService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ReturnController {

    @FXML private TableView<ReturnBook> issuedBooksTable;
    @FXML private TableColumn<ReturnBook, String> idColumn;
    @FXML private TableColumn<ReturnBook, String> nameColumn;
    @FXML private TableColumn<ReturnBook, String> phoneColumn;
    @FXML private TableColumn<ReturnBook, String> genderColumn;
    @FXML private TableColumn<ReturnBook, String> bookColumn;
    @FXML private TableColumn<ReturnBook, String> issueDateColumn;
    @FXML private TableColumn<ReturnBook, String> returnDateColumn;

    @FXML private HBox detailsBox;
    @FXML private ImageView bookImageView;
    @FXML private Label titleLabel;
    @FXML private Label authorLabel;
    @FXML private Label publisherLabel;
    @FXML private Label quantityLabel;
    @FXML private Label issuedDateLabel;
    @FXML private DatePicker returnDatePicker;

    private final ReturnService returnService = new ReturnService();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        bookColumn.setCellValueFactory(cellData -> cellData.getValue().bookTitleProperty());
        issueDateColumn.setCellValueFactory(cellData -> cellData.getValue().issueDateProperty());
        returnDateColumn.setCellValueFactory(cellData -> cellData.getValue().returnDateProperty());

        issuedBooksTable.setItems(returnService.getIssuedBooks());

        // Add listener to show details when a row is selected
        issuedBooksTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        populateDetails(newSelection);
                    }
                }
        );
    }

    private void populateDetails(ReturnBook book) {
        titleLabel.setText(book.getBookTitle());
        authorLabel.setText(book.getAuthor());
        publisherLabel.setText(book.getPublisher());
        quantityLabel.setText(book.getQuantity());
        issuedDateLabel.setText(book.getIssueDate());

        // Load the image
        if (book.getImagePath() != null && !book.getImagePath().isEmpty()) {
            bookImageView.setImage(new Image(getClass().getResourceAsStream(book.getImagePath())));
        }

        detailsBox.setVisible(true); // Show the details box
    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        System.out.println("Return button clicked.");
        // Logic to process the book return would go here

        // Clear selection and hide details
        issuedBooksTable.getSelectionModel().clearSelection();
        detailsBox.setVisible(false);
    }
}
