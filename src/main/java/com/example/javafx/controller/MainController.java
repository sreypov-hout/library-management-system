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

    /**
     * This method is called when the FXML is loaded. It sets the dashboard as the default view.
     */
    @FXML
    public void initialize() {
        // Load the Dashboard view by default when the application starts
        handleDashboardClick(null);
    }

    @FXML
    private void handleDashboardClick(ActionEvent event) {
        loadView("/com/example/javafx/fxml/DashboardView.fxml");
        setActiveButton(dashboardButton);
    }

    @FXML
    private void handleBooksClick(ActionEvent event) {
        loadView("/com/example/javafx/fxml/BookView.fxml");
        setActiveButton(booksButton);
    }

    @FXML
    private void handleBorrowersClick(ActionEvent event) {
        loadView("/com/example/javafx/fxml/BorrowerView.fxml");
        setActiveButton(borrowersButton);
    }

    @FXML
    private void handleIssueReturnClick(ActionEvent event) {
        loadView("/com/example/javafx/fxml/IssueReturnView.fxml");
        setActiveButton(issueButton);
    }

    /**
     * Loads a view into the center of the main layout.
     * @param fxmlPath The path to the FXML file.
     */
    private void loadView(String fxmlPath) {
        try {
            URL fxmlUrl = getClass().getResource(fxmlPath);
            if (fxmlUrl == null) {
                System.err.println("Cannot find FXML file: " + fxmlPath);
                mainPane.setCenter(null); // Clear the center if view not found
                return;
            }
            Parent view = FXMLLoader.load(fxmlUrl);
            mainPane.setCenter(view);
        } catch (IOException e) {
            System.err.println("Failed to load FXML file: " + fxmlPath);
            e.printStackTrace();
        }
    }

    /**
     * Changes the CSS style to highlight the active button.
     * @param activeButton The button that was clicked.
     */
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

