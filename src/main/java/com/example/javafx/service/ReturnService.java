package com.example.javafx.service;

import com.example.javafx.model.ReturnBook;
import com.example.javafx.repository.ReturnRepository;
import javafx.collections.ObservableList;

public class ReturnService {
    private final ReturnRepository returnRepository = new ReturnRepository();

    public ObservableList<ReturnBook> getIssuedBooks() {
        return returnRepository.getIssuedBooks();
    }
}
