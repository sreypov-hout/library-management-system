package com.example.javafx.service;

import com.example.javafx.model.Borrower;
import com.example.javafx.repository.BorrowerRepository;
import javafx.collections.ObservableList;

public class BorrowerService {
    private final BorrowerRepository borrowerRepository = new BorrowerRepository();

    public ObservableList<Borrower> getAllBorrowers() {
        return borrowerRepository.getAllBorrowers();
    }
}
