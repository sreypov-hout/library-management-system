package com.example.javafx.controller;

import com.example.javafx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink; // <-- I've added this import
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    private MainApplication mainApplication;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    // --- Fields for password visibility ---
    // I've uncommented these fields for the toggle method to work
    @FXML
    private TextField visiblePasswordField;
    private boolean passwordVisible = false;
    // ------------------------------------

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @FXML
    private void initialize() {
        // This makes sure the visible text field is not shown when the app starts
        visiblePasswordField.setManaged(false);
        visiblePasswordField.setVisible(false);
    }

    @FXML
    private void handleLoginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("user".equals(username) && "password".equals(password)) {
            System.out.println("Login Successful!");
            if (mainApplication != null) {
                mainApplication.showMainLibraryView();
            } else {
                System.err.println("MainApplication reference is not set!");
            }
        } else {
            System.out.println("Invalid Credentials");
        }
    }

    /**
     * I have uncommented this method and completed it for you.
     * It shows/hides the password text when the "Hide"/"Show" hyperlink is clicked.
     */
    @FXML
    private void togglePasswordVisibility(ActionEvent event) {
        passwordVisible = !passwordVisible;
        Hyperlink toggleLink = (Hyperlink) event.getSource();

        if (passwordVisible) {
            // Show password: copy text to visible field and swap visibility
            visiblePasswordField.setText(passwordField.getText());
            passwordField.setVisible(false);
            passwordField.setManaged(false);
            visiblePasswordField.setVisible(true);
            visiblePasswordField.setManaged(true);
            toggleLink.setText("Hide"); // Update link text
        } else {
            // Hide password: copy text back to password field and swap visibility
            passwordField.setText(visiblePasswordField.getText());
            visiblePasswordField.setVisible(false);
            visiblePasswordField.setManaged(false);
            passwordField.setVisible(true);
            passwordField.setManaged(true);
            toggleLink.setText("Show"); // Update link text
        }
    }
}