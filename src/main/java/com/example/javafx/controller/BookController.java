package com.example.javafx.controller;

import com.example.javafx.model.Book;
import com.example.javafx.service.BookService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import java.io.File;

public class BookController {

    @FXML private TextField isbnField;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField genreField;
    @FXML private TextField quantityField;
    @FXML private Label imagePathLabel;
    @FXML private Label statusLabel;
    @FXML private TableView<Book> bookTableView;
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, Number> quantityColumn;
    private final BookService bookService = new BookService();
    private String selectedImagePath = "";

    @FXML
    public void initialize() {
        isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
        bookTableView.setItems(bookService.getAllBooks());
    }

    @FXML
    protected void handleAddBook() {
        try {
            String isbn = isbnField.getText();
            String title = titleField.getText();
            String author = authorField.getText();
            String genre = genreField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            bookService.addBook(isbn, title, author, genre, quantity, selectedImagePath);
            statusLabel.setText("Book added successfully!");
            handleClearFields();
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Quantity must be a number.");
        } catch (IllegalArgumentException e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    protected void handleClearFields() {
        isbnField.clear();
        titleField.clear();
        authorField.clear();
        genreField.clear();
        quantityField.clear();
        imagePathLabel.setText("No image selected");
        selectedImagePath = "";
        statusLabel.setText("");
    }

    @FXML
    protected void handleSelectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Book Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(imagePathLabel.getScene().getWindow());
        if (selectedFile != null) {
            selectedImagePath = selectedFile.getAbsolutePath();
            imagePathLabel.setText(selectedFile.getName());
        }
    }
}