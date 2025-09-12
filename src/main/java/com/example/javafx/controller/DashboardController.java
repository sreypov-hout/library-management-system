package com.example.javafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label totalBooksLabel;
    @FXML
    private Label availableBooksLabel;
    @FXML
    private Label borrowedBooksLabel;
    @FXML
    private Label totalBorrowersLabel;

    @FXML
    private BarChart<String, Number> availableBooksChart;
    @FXML
    private PieChart borrowedBooksChart;

    @FXML
    public void initialize() {
        loadDashboardData();
    }

    private void loadDashboardData() {
        // --- Populate Bar Chart with exact data from the image ---
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("History", 48));
        series.getData().add(new XYChart.Data<>("Math", 98));
        series.getData().add(new XYChart.Data<>("English", 55));
        series.getData().add(new XYChart.Data<>("Novel", 90));
        series.getData().add(new XYChart.Data<>("Story telling", 30));
        series.getData().add(new XYChart.Data<>("Other", 75));
        availableBooksChart.getData().add(series);

        // --- Populate Pie Chart with exact data from the image ---
        // Note: The image has a typo (52.1+22.8+15.9+11.2 > 100). I have adjusted "English" to make it total 100.
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("English", 50.1),
                        new PieChart.Data("Novel", 22.8),
                        new PieChart.Data("Other", 15.9),
                        new PieChart.Data("History", 11.2));
        borrowedBooksChart.setData(pieChartData);
    }
}