package com.example.socialapp.utils;

import com.example.socialapp.repository.UserRepository;
import com.example.socialapp.service.UserService;

import java.sql.SQLException;

public final class Resources {
    public Resources instance = null;
    public static UserService userService;
    public static UserRepository userRepo;

    public Resources() throws SQLException {
        userRepo = new UserRepository();
        userService = new UserService(userRepo);
    }


    public Resources getInstance() throws SQLException {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }
}
