package com.example.javafx.controller;

import com.example.javafx.model.Borrower;
import com.example.javafx.service.BorrowerService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BorrowerController {

    @FXML
    private TableView<Borrower> borrowerTableView;
    @FXML
    private TableColumn<Borrower, String> idColumn;
    @FXML
    private TableColumn<Borrower, String> nameColumn;
    @FXML
    private TableColumn<Borrower, String> phoneColumn;
    @FXML
    private TableColumn<Borrower, String> genderColumn;
    @FXML
    private TableColumn<Borrower, String> bookColumn;
    @FXML
    private TableColumn<Borrower, String> issueDateColumn;
    @FXML
    private TableColumn<Borrower, String> returnDateColumn;

    private final BorrowerService borrowerService = new BorrowerService();

    @FXML
    public void initialize() {
        // Set up table columns to display borrower properties
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        bookColumn.setCellValueFactory(cellData -> cellData.getValue().bookProperty());
        issueDateColumn.setCellValueFactory(cellData -> cellData.getValue().issueDateProperty());
        returnDateColumn.setCellValueFactory(cellData -> cellData.getValue().returnDateProperty());

        // Load initial data into the table
        borrowerTableView.setItems(borrowerService.getAllBorrowers());
    }
}
