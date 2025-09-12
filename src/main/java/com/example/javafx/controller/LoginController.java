package com.example.javafx.controller;

import com.example.javafx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

    @FXML
    private TextField visiblePasswordField;
    private boolean passwordVisible = false;

    public void setMainApplication(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @FXML
    private void initialize() {
        visiblePasswordField.setManaged(false);
        visiblePasswordField.setVisible(false);
    }

    @FXML
    private void handleLoginButton(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordVisible ? visiblePasswordField.getText() : passwordField.getText();

        // --- I HAVE UPDATED THIS LINE ---
        // It now checks for the username "momo" and password "12345"
        if ("mo".equals(username) && "123".equals(password)) {
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

    @FXML
    private void togglePasswordVisibility(ActionEvent event) {
        passwordVisible = !passwordVisible;
        Hyperlink toggleLink = (Hyperlink) event.getSource();

        if (passwordVisible) {
            visiblePasswordField.setText(passwordField.getText());
            passwordField.setVisible(false);
            passwordField.setManaged(false);
            visiblePasswordField.setVisible(true);
            visiblePasswordField.setManaged(true);
            toggleLink.setText("Hide");
        } else {
            passwordField.setText(visiblePasswordField.getText());
            visiblePasswordField.setVisible(false);
            visiblePasswordField.setManaged(false);
            passwordField.setVisible(true);
            passwordField.setManaged(true);
            toggleLink.setText("Show");
        }
    }
}