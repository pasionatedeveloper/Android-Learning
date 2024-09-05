package com.ajssoftwares.myapplication;

public class User {

    String userName;
    String userContact;
    int userAge;

    public User() {
        // Required empty public constructor
    }

    public User(String userName, String userContact, int userAge) {
        this.userName = userName;
        this.userContact = userContact;
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserContact() {
        return userContact;
    }

    public int getUserAge() {
        return userAge;
    }
}