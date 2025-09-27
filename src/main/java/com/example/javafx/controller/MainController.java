package com.example.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox; // Import VBox

import java.io.IOException;
import java.net.URL;

public class MainController {

    @FXML
    private BorderPane mainPane;
    @FXML
    private VBox contentArea; // This is the new VBox for content
    @FXML
    private Button dashboardButton;
    @FXML
    private Button booksButton;
    @FXML
    private Button borrowersButton;
    @FXML
    private Button issueButton;
    @FXML
    private Button returnBooksButton;


    private Button currentButton;

    @FXML
    public void initialize() {
        handleDashboardClick(null);
    }

    @FXML
    private void handleDashboardClick(ActionEvent event) {
        loadView("/com/example/javafx/DashboardView.fxml");
        setActiveButton(dashboardButton);
    }

    @FXML
    private void handleBooksClick(ActionEvent event) {
        loadView("/com/example/javafx/BookView.fxml");
        setActiveButton(booksButton);
    }

    @FXML
    private void handleBorrowersClick(ActionEvent event) {
        loadView("/com/example/javafx/BorrowerView.fxml");
        setActiveButton(borrowersButton);
    }

    @FXML
    private void handleIssueReturnClick(ActionEvent event) {
        loadView("/com/example/javafx/IssueReturnView.fxml");
        setActiveButton(issueButton);
    }

    @FXML
    private void handleReturnBooksClick(ActionEvent event) {
        // You can create a ReturnView.fxml for this later
         loadView("/com/example/javafx/ReturnView.fxml");
        setActiveButton(returnBooksButton);
    }

    @FXML
    private void handleAddMemberClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/javafx/AddMemberView.fxml"));
            Parent addMemberPage = loader.load();

            // Clear old content then add new page
            contentArea.getChildren().clear();
            contentArea.getChildren().add(addMemberPage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    private void handleReturnBooksClick(ActionEvent event) {
//        loadView("/com/example/javafx/ReturnView.fxml");
//        setActiveButton(returnBooksButton);
//    }


    private void loadView(String fxmlPath) {
        try {
            URL fxmlUrl = getClass().getResource(fxmlPath);
            if (fxmlUrl == null) {
                System.err.println("Cannot find FXML file: " + fxmlPath);
                contentArea.getChildren().clear();
                return;
            }
            Parent view = FXMLLoader.load(fxmlUrl);
            contentArea.getChildren().setAll(view); // Load content into the VBox
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setActiveButton(Button activeButton) {
        if (currentButton != null) {
            currentButton.getStyleClass().remove("sidebar-button-active");
        }
        activeButton.getStyleClass().add("sidebar-button-active");
        currentButton = activeButton;
    }
}