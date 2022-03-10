package com.example.socialapp.utils;

import com.example.socialapp.domain.FriendshipValidator;
import com.example.socialapp.domain.validation.UserValidator;
import com.example.socialapp.repository.FriendshipRepository;
import com.example.socialapp.repository.FriendshipRequestRepository;
import com.example.socialapp.repository.LoginRepository;
import com.example.socialapp.repository.UserRepository;
import com.example.socialapp.service.FriendshipRequestService;
import com.example.socialapp.service.FriendshipService;
import com.example.socialapp.service.FriendshipSuperService;
import com.example.socialapp.service.UserService;

import java.sql.SQLException;

public class Resources {
    private static Resources instance = null;
    public static UserService userService;
    public static UserRepository userRepo;
    public static FriendshipRepository friendshipRepo;
    public static LoginRepository loginRepo;
    public static FriendshipService friendshipService;
    public static FriendshipValidator friendshipValidator;
    public static UserValidator userValidator;
    public static CurrentUser currentUser;
    public static PasswordAuthentication passwordAuthentication;
    public static FriendshipRequestRepository requestRepository;
    public static FriendshipRequestService requestService;
    public static FriendshipSuperService friendshipSuperService;

    private Resources() throws SQLException {
        userRepo = new UserRepository();
        friendshipRepo = new FriendshipRepository();
        loginRepo = new LoginRepository();
        friendshipValidator = new FriendshipValidator();
        userValidator = new UserValidator();
        userService = new UserService(userRepo, loginRepo, userValidator);
        friendshipService = new FriendshipService(friendshipRepo, friendshipValidator);
        currentUser = CurrentUser.getInstance();
        requestRepository = new FriendshipRequestRepository();
        requestService = new FriendshipRequestService(requestRepository);
        friendshipSuperService = new FriendshipSuperService(userService, friendshipService);
        //passwordAuthentication = new PasswordAuthentication();
    }


    public static Resources getInstance() throws SQLException {
        if (instance == null) {
            instance = new Resources();
        }
        return instance;
    }
}
