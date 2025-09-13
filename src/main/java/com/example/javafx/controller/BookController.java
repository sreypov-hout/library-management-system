package com.example.javafx.controller;

import com.example.javafx.model.Book;
import com.example.javafx.service.BookService;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;

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

    private final BookService bookService = new BookService();
    private String selectedImagePath = "";

    @FXML
    public void initialize() {
        setupTableColumns();
        bookTableView.setItems(bookService.getAllBooks());

        bookTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateForm(newSelection);
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
                    setText(null);
                    setGraphic(null);
                    setAlignment(Pos.CENTER);
                } else {
                    Label statusLabel = new Label(item);
                    statusLabel.getStyleClass().add("status-label");
                    if ("Available".equalsIgnoreCase(item)) {
                        statusLabel.getStyleClass().add("status-available");
                    } else {
                        statusLabel.getStyleClass().add("status-unavailable");
                    }
                    setGraphic(statusLabel);
                    setAlignment(Pos.CENTER);
                }
            }
        });
    }

    private void populateForm(Book book) {
        isbnField.setText(book.getIsbn());
        titleField.setText(book.getTitle());
        authorField.setText(book.getAuthor());
        publisherField.setText(book.getPublisher());
        quantityField.setText(String.valueOf(book.getQuantity()));
        descriptionArea.setText(book.getDescription());
        selectedImagePath = book.getImagePath();
        if (selectedImagePath != null && !selectedImagePath.isEmpty()) {
            bookImageView.setImage(new Image(selectedImagePath));
        } else {
            bookImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/placeholders/default-book.png")));
        }
    }

    @FXML
    protected void handleAddBook() {
        try {
            bookService.addBook(
                    isbnField.getText(),
                    titleField.getText(),
                    authorField.getText(),
                    publisherField.getText(),
                    Integer.parseInt(quantityField.getText()),
                    descriptionArea.getText(),
                    selectedImagePath
            );
            statusLabel.setText("Book added successfully!");
            handleClearFields();
            bookTableView.refresh();
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    protected void handleUpdateButton() {
        System.out.println("Update book clicked");
        statusLabel.setText("Book updated successfully!");
    }

    @FXML
    protected void handleDeleteButton() {
        System.out.println("Delete book clicked");
        statusLabel.setText("Book deleted successfully!");
    }

    @FXML
    protected void handleClearFields() {
        isbnField.clear();
        titleField.clear();
        authorField.clear();
        publisherField.clear();
        quantityField.clear();
        descriptionArea.clear();
        bookImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/placeholders/default-book.png")));
        selectedImagePath = "";
        statusLabel.setText("");
        bookTableView.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleSelectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Book Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(statusLabel.getScene().getWindow());
        if (selectedFile != null) {
            selectedImagePath = selectedFile.toURI().toString();
            bookImageView.setImage(new Image(selectedImagePath));
        }
    }
}

