package com.example.javafx.repository;

import com.example.javafx.model.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MemberRepository {
    private final ObservableList<Member> members = FXCollections.observableArrayList();

    public MemberRepository() {
        // Sample data for the table
        members.add(new Member("M001", "John Doe", "john.d@example.com", "012-345-678", "Male", "Active", ""));
        members.add(new Member("M002", "Jane Smith", "jane.s@example.com", "098-765-432", "Female", "Active", ""));
        members.add(new Member("M003", "Peter Jones", "peter.j@example.com", "011-223-344", "Male", "Inactive", ""));
    }

    public ObservableList<Member> getAllMembers() {
        return members;
    }
}

