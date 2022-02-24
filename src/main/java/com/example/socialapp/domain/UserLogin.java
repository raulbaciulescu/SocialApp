package com.example.socialapp.domain;

import com.example.socialapp.utils.PasswordAuthentication;

public class UserLogin extends User {
    private String username;
    private String hashedPassword;
    public UserLogin(long id, String firstName, String lastName, String username, String password) {
        super(id, firstName, lastName);
        this.username = username;
        this.hashedPassword = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
