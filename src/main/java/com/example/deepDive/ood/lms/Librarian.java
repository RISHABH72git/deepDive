package com.example.deepDive.ood.lms;

import com.example.deepDive.ood.Account;

public class Librarian extends Account {

    public boolean addBookItem(BookItem bookItem) {
        return false;
    }

    public boolean blockMember(Member member) {
        return false;
    }

    public boolean unBlockMember(Member member) {
        return false;
    }
}
