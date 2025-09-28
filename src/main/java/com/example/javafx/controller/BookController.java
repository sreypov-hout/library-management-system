package com.example.javafx.controller;

import com.example.javafx.Database.ConnectDatabase;
import com.example.javafx.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookController {

    @FXML private ImageView bookImageView;
    @FXML private TextField isbnField;
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField publisherField;
    @FXML private TextField quantityField;
    @FXML private TextArea descriptionArea;
    @FXML private Label statusLabel;

    @FXML private TableView<Book> bookTableView;
    @FXML private TableColumn<Book, String> isbnColumn;
    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> publisherColumn;
    @FXML private TableColumn<Book, Integer> quantityColumn;
    @FXML private TableColumn<Book, String> statusColumn;

    private String selectedImagePath = "";
    private ObservableList<Book> books = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        setupTableColumns();
        bookTableView.setItems(books);
        loadBooksFromDatabase();

        // When selecting a row → show details in form
        bookTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                populateForm(newSel);
            }
        });
    }

    private void setupTableColumns() {
        isbnColumn.setCellValueFactory(cellData -> cellData.getValue().isbnProperty());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        authorColumn.setCellValueFactory(cellData -> cellData.getValue().authorProperty());
        publisherColumn.setCellValueFactory(cellData -> cellData.getValue().publisherProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        statusColumn.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    Label lbl = new Label(item);
                    lbl.getStyleClass().add("status-label");
                    if ("Available".equalsIgnoreCase(item)) {
                        lbl.getStyleClass().add("status-available");
                    } else {
                        lbl.getStyleClass().add("status-unavailable");
                    }
                    setGraphic(lbl);
                    setAlignment(Pos.CENTER);
                }
            }
        });
    }

    private void loadBooksFromDatabase() {
        books.clear();
        String query = "SELECT isbn, title, author, publisher, quantity, description, image_path FROM books ORDER BY isbn";

        try (Connection conn = ConnectDatabase.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Book book = new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("quantity"),
                        rs.getString("description"),
                        rs.getString("image_path")
                );

                // load image from local path
                String path = rs.getString("image_path");
                if (path != null) {
                    File imgFile = new File(path);
                    if (imgFile.exists()) {
                        book.setImage(new Image(imgFile.toURI().toString()));
                    } else {
                        book.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/book_covers/no-img.png")));
                    }
                } else {
                    book.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/book_covers/no-img.png")));
                }

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            statusLabel.setText("⚠ Error loading books: " + e.getMessage());
        }
    }

    private void populateForm(Book book) {
        isbnField.setText(book.getIsbn());
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        publisherField.setText(book.getPublisher());
        quantityField.setText(String.valueOf(book.getQuantity()));
        descriptionArea.setText(book.getDescription());
        selectedImagePath = book.getImagePath();

        if (book.getImage() != null) {
            bookImageView.setImage(book.getImage());
        } else {
            bookImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/book_covers/no-img.png")));
        }
    }

    @FXML
    protected void handleAddBook() {
        String query = "INSERT INTO books (isbn, title, author, publisher, quantity, description, image_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDatabase.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, isbnField.getText());
            pstmt.setString(2, titleField.getText());
            pstmt.setString(3, authorField.getText());
            pstmt.setString(4, publisherField.getText());
            pstmt.setInt(5, Integer.parseInt(quantityField.getText()));
            pstmt.setString(6, descriptionArea.getText());
            pstmt.setString(7, selectedImagePath); // save local path

            pstmt.executeUpdate();

            statusLabel.setText("✅ Book added successfully!");
            loadBooksFromDatabase();
            handleClearFields();
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setText("❌ Error adding book: " + e.getMessage());
        }
    }

    @FXML
    protected void handleUpdateButton() {
        String query = "UPDATE books SET title=?, author=?, publisher=?, quantity=?, description=?, image_path=? WHERE isbn=?";
        try (Connection conn = ConnectDatabase.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, titleField.getText());
            pstmt.setString(2, authorField.getText());
            pstmt.setString(3, publisherField.getText());
            pstmt.setInt(4, Integer.parseInt(quantityField.getText()));
            pstmt.setString(5, descriptionArea.getText());
            pstmt.setString(6, selectedImagePath);
            pstmt.setString(7, isbnField.getText());
            pstmt.executeUpdate();

            statusLabel.setText("✅ Book updated successfully!");
            loadBooksFromDatabase();
            handleClearFields();
        } catch (SQLException | NumberFormatException e) {
            statusLabel.setText("❌ Error updating book: " + e.getMessage());
        }
    }

    @FXML
    protected void handleDeleteButton() {
        String query = "DELETE FROM books WHERE isbn=?";
        try (Connection conn = ConnectDatabase.connectionDB();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, isbnField.getText());
            pstmt.executeUpdate();

            statusLabel.setText("✅ Book deleted successfully!");
            loadBooksFromDatabase();
            handleClearFields();
        } catch (SQLException e) {
            statusLabel.setText("❌ Error deleting book: " + e.getMessage());
        }
    }

    @FXML
    protected void handleClearFields() {
        isbnField.clear();
        titleField.clear();
        authorField.clear();
        publisherField.clear();
        quantityField.clear();
        descriptionArea.clear();
        bookImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/book_covers/no-img.png")));
        selectedImagePath = "";
        statusLabel.setText("");
        bookTableView.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleSelectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Book Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(statusLabel.getScene().getWindow());
        if (selectedFile != null) {
            try {
                // save absolute path to DB
                selectedImagePath = selectedFile.getAbsolutePath();

                // preview
                bookImageView.setImage(new Image(selectedFile.toURI().toString()));
                statusLabel.setText("✅ Image selected successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                statusLabel.setText("⚠ Failed to load image: " + e.getMessage());
            }
        }
    }
}
