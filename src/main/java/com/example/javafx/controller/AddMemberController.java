package com.example.javafx.controller;

import com.example.javafx.model.Member;
import com.example.javafx.service.MemberService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;

public class AddMemberController {

    @FXML private ImageView memberImageView;
    @FXML private TextField memberIdField;
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private ComboBox<String> genderComboBox;
    @FXML private Label statusLabel;
    @FXML private TableView<Member> memberTableView;
    @FXML private TableColumn<Member, String> idColumn;
    @FXML private TableColumn<Member, String> nameColumn;
    @FXML private TableColumn<Member, String> emailColumn;
    @FXML private TableColumn<Member, String> phoneColumn;
    @FXML private TableColumn<Member, String> genderColumn;
    @FXML private TableColumn<Member, String> statusColumn;

    private final MemberService memberService = new MemberService();
    private String selectedImagePath = "";

    @FXML
    public void initialize() {
        genderComboBox.setItems(FXCollections.observableArrayList("Male", "Female", "Other"));
        setupTableColumns();
        memberTableView.setItems(memberService.getAllMembers());
    }

    private void setupTableColumns() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        statusColumn.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    Label statusLabel = new Label(item);
                    statusLabel.getStyleClass().add("status-label");
                    // Use the same styles as book availability for consistency
                    if ("Active".equalsIgnoreCase(item)) {
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

    @FXML
    protected void handleAddMember() {
        // Placeholder logic
        statusLabel.setText("Member added successfully!");
    }

    @FXML
    protected void handleUpdateMember() {
        // Placeholder logic
        statusLabel.setText("Member updated successfully!");
    }

    @FXML
    protected void handleDeleteMember() {
        // Placeholder logic
        statusLabel.setText("Member deleted successfully!");
    }

    @FXML
    protected void handleClearFields() {
        memberIdField.clear();
        nameField.clear();
        emailField.clear();
        phoneField.clear();
        genderComboBox.getSelectionModel().clearSelection();
        // Ensure you have a default placeholder image at this path
        memberImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/javafx/images/book_covers/no-img.png")));
        selectedImagePath = "";
        statusLabel.setText("");
    }

    @FXML
    protected void handleSelectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Member Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File selectedFile = fileChooser.showOpenDialog(statusLabel.getScene().getWindow());
        if (selectedFile != null) {
            selectedImagePath = selectedFile.toURI().toString();
            memberImageView.setImage(new Image(selectedImagePath));
        }
    }
}

