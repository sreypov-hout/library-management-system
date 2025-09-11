package com.example.javafx;

import com.example.javafx.controller.LoginController;
import com.example.javafx.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private Stage primaryStage; // <-- THIS IS THE MISSING LINE. Declare it here.

    @Override
    public void start(Stage stage) {
        // Now, assign the stage from the start method to our class variable
        this.primaryStage = stage;
        showLoginView();
    }

    public void showLoginView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/javafx/LoginView.fxml"));
            Parent root = fxmlLoader.load();

            LoginController loginController = fxmlLoader.getController();
            loginController.setMainApplication(this);

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/com/example/javafx/css/styles.css").toExternalForm());

            // This line will now work because primaryStage is visible to the whole class
            primaryStage.setTitle("Library System - Login");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMainLibraryView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/javafx/MainView.fxml"));
            Parent root = fxmlLoader.load();

            MainController mainController = fxmlLoader.getController();
            // mainController.setMainApplication(this); // Optional: if your main view needs this

            Scene scene = new Scene(root, 1100, 700);
            scene.getStylesheets().add(getClass().getResource("/com/example/javafx/css/styles.css").toExternalForm());

            // This line will also work now
            primaryStage.setTitle("Library Management System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}