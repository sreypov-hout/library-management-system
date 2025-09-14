package com.example.javafx.repository;

import com.example.javafx.model.ReturnBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReturnRepository {
    private final ObservableList<ReturnBook> issuedBooks = FXCollections.observableArrayList();

    public ReturnRepository() {
        // Sample data matching the UI
        issuedBooks.add(new ReturnBook("01", "Kim Nita", "093 5676 678", "Female", "Follow your heart", "27/3/2025", "30/3/2025", "Andrew Matthews", "1999", "05", "/com/example/javafx/images/book_covers/follow-your-heart.png"));
        issuedBooks.add(new ReturnBook("02", "Chan David", "092 5644 521", "Male", "Law of Attraction", "15/4/2025", "20/4/2025", "Author Name", "2010", "02", "/com/example/javafx/images/book_covers/law-of-attraction.png"));
        issuedBooks.add(new ReturnBook("03", "Ling Jing", "077 1298 390", "Female", "The 48 Laws of power", "20/5/2025", "28/5/2025", "Robert Greene", "1998", "10", "/com/example/javafx/images/book_covers/power.png"));
        issuedBooks.add(new ReturnBook("04", "Meng Heang", "097 4444 696", "Male", "Romeo and Juliet", "01/6/2025", "14/6/2025", "William Shakespeare", "1597", "07", "/com/example/javafx/images/book_covers/romeo-juliet.png"));
        issuedBooks.add(new ReturnBook("05", "Chea Seng", "088 5364 911", "Male", "Harry Potter", "11/7/2025", "23/7/2025", "J. K. Rowling", "1986", "01", "/com/example/javafx/images/book_covers/harry-potter.png"));
        issuedBooks.add(new ReturnBook("06", "Park Jimin", "016 2343 678", "Male", "Rich Dad Poor Dad", "24/8/2025", "29/8/2025", "Robert Kiyosaki", "1997", "12", "/com/example/javafx/images/book_covers/rich-dad-poor-dad.png"));
    }

    public ObservableList<ReturnBook> getIssuedBooks() {
        return issuedBooks;
    }
}
