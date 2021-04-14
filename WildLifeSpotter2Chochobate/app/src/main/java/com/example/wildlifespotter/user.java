package com.example.wildlifespotter;

import com.google.firebase.firestore.auth.User;

public class user {
    public String username,password;

    public user(String username, String password){
        this.username = username;
        this.password = password;
    }

    user()
    {}
}
