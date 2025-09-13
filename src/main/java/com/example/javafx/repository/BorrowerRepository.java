package com.example.javafx.repository;

import com.example.javafx.model.Borrower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BorrowerRepository {
    private final ObservableList<Borrower> borrowers = FXCollections.observableArrayList();

    public BorrowerRepository() {
        // Add sample data that matches the image
        borrowers.add(new Borrower("01", "Kim Nita", "093 5676 678", "Female", "Follow your heart", "27/3/2025", "30/3/2025"));
        borrowers.add(new Borrower("02", "Chan David", "092 5644 521", "Male", "Law of Attraction", "15/4/2025", "20/4/2025"));
        borrowers.add(new Borrower("03", "Ling Jing", "077 1298 390", "Female", "The 48 Laws of power", "20/5/2025", "28/5/2025"));
        borrowers.add(new Borrower("04", "Meng Heang", "097 4444 696", "Male", "Romeo and Juliet", "01/6/2025", "14/6/2025"));
        borrowers.add(new Borrower("05", "Chea Seng", "088 5364 911", "Male", "Harry Potter", "11/7/2025", "23/7/2025"));
        borrowers.add(new Borrower("06", "Park Jimin", "016 2343 678", "Male", "Rich Dad Poor Dad", "24/8/2025", "29/8/2025"));
    }

    public ObservableList<Borrower> getAllBorrowers() {
        return borrowers;
    }
}
