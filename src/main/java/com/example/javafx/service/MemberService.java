package com.example.javafx.service;

import com.example.javafx.model.Member;
import com.example.javafx.repository.MemberRepository;
import javafx.collections.ObservableList;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public ObservableList<Member> getAllMembers() {
        return memberRepository.getAllMembers();
    }
}

