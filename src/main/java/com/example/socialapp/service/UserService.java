package com.example.socialapp.service;

import com.example.socialapp.domain.User;
import com.example.socialapp.repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(User user) {

    }

    public ArrayList<User> getAll() throws SQLException {
        return userRepository.getAll();
    }

    public Optional<User> findByID(long id) throws SQLException {
        return userRepository.findByID(id);
    }

}
