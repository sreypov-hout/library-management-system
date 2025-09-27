package com.example.javafx;

import com.example.javafx.controller.LoginController;
import com.example.javafx.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.Connection;
import com.example.javafx.Database.ConnectDatabase;


public class MainApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        // ✅ Test database connection here
        try {
            Connection connection = ConnectDatabase.connectionDB();

            if (connection != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Database Connection");
                alert.setHeaderText(null);
                alert.setContentText("✅ Successfully connected to the database!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Connection");
                alert.setHeaderText(null);
                alert.setContentText("❌ Failed to connect to the database. Connection returned null.");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Connection");
            alert.setHeaderText(null);
            alert.setContentText("❌ Failed to connect to the database. Please check your settings.");
            alert.showAndWait();

            e.printStackTrace();
        }

        // After testing DB connection, show login screen
        showLoginView();
    }

    public void showLoginView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/com/example/javafx/LoginView.fxml"));
            Parent root = fxmlLoader.load();

            LoginController loginController = fxmlLoader.getController();
            loginController.setMainApplication(this);

            Scene scene = new Scene(root, 800, 600);
            scene.getStylesheets().add(getClass().getResource("/com/example/javafx/css/style.css").toExternalForm());

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

            Scene scene = new Scene(root, 1100, 700);
            scene.getStylesheets().add(getClass().getResource("/com/example/javafx/css/style.css").toExternalForm());

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
