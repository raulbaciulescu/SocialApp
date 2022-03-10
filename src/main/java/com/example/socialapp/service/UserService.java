package com.example.socialapp.service;

import com.example.socialapp.domain.User;
import com.example.socialapp.domain.UserLogin;
import com.example.socialapp.domain.validation.UserValidator;
import com.example.socialapp.repository.LoginRepository;
import com.example.socialapp.repository.UserRepository;
import com.example.socialapp.utils.PasswordAuthentication;
import com.example.socialapp.utils.Resources;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class UserService {
    private final UserRepository userRepository;
    private final LoginRepository loginRepository;
    private final UserValidator userValidator;
    private Random random;

    public UserService(UserRepository userRepository, LoginRepository loginRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
        this.userValidator = userValidator;
        this.random = new Random();
    }

    public void add(String firstName, String lastName) throws SQLException {
        final long id = this.random.nextInt();
        User user = new User(id, firstName, lastName);
        userValidator.validate(user);
        userRepository.add(user);
    }

    public ArrayList<User> getAll() throws SQLException {
        return userRepository.getAll();
    }

    public Optional<User> findByID(long id) throws SQLException {
        return userRepository.findByID(id);
    }

    public Optional<UserLogin> findUserLogin(String username, String password) throws SQLException, NoSuchAlgorithmException {
        String hashedPassword = PasswordAuthentication.hash(password, username);
        return loginRepository.find(username, hashedPassword);
    }

    public void addUserLogin(String username, String password, String firstName, String lastName) throws SQLException, NoSuchAlgorithmException {
        final long id = this.random.nextInt();
        User user = new User(id, firstName, lastName);
        userValidator.validate(user);
        String hashedPassword = PasswordAuthentication.hash(password, username);
        UserLogin userLogin = new UserLogin(username, hashedPassword, id);
        loginRepository.add(userLogin);
        userRepository.add(user);
    }
}
