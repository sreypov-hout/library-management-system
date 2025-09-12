package com.example.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;

public class MainController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button dashboardButton;
    @FXML
    private Button booksButton;
    @FXML
    private Button borrowersButton;
    @FXML
    private Button issueButton;

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

    private void loadView(String fxmlPath) {
        try {
            URL fxmlUrl = getClass().getResource(fxmlPath);
            if (fxmlUrl == null) {
                System.err.println("Cannot find FXML file: " + fxmlPath);
                mainPane.setCenter(null);
                return;
            }
            Parent view = FXMLLoader.load(fxmlUrl);
            mainPane.setCenter(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setActiveButton(Button activeButton) {
        if (currentButton != null) {
            currentButton.getStyleClass().remove("sidebar-button-active");
        }
        currentButton = activeButton;
        if (currentButton != null) {
            currentButton.getStyleClass().add("sidebar-button-active");
        }
    }
}