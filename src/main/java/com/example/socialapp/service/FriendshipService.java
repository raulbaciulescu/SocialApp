package com.example.socialapp.service;


import com.example.socialapp.domain.Friendship;
import com.example.socialapp.domain.FriendshipValidator;
import com.example.socialapp.domain.Tuple;
import com.example.socialapp.domain.User;
import com.example.socialapp.repository.FriendshipRepository;
import com.example.socialapp.repository.Repository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FriendshipService {
    private final FriendshipRepository friendshipRepository;
    private final FriendshipValidator friendshipValidator;

    public FriendshipService(FriendshipRepository friendshipRepository,
                             FriendshipValidator friendshipValidator) {
        this.friendshipRepository = friendshipRepository;
        this.friendshipValidator = friendshipValidator;
    }

    public void add(final User first, final User second) throws SQLException {
        final LocalDateTime currentTimestamp = LocalDateTime.now();
        final Tuple<User, User> users = new Tuple<>(first, second);
        final Friendship friendship = new Friendship(currentTimestamp, users);
        this.friendshipValidator.validate(friendship);
        this.friendshipRepository.add(friendship);
    }

    public void delete(final Tuple<Long, Long> tuple) throws SQLException {
        this.friendshipRepository.delete(tuple);
    }


    public Optional<Friendship> findByID(final Tuple<Long, Long> tuple) throws SQLException {
        return this.friendshipRepository.findByID(tuple);
    }


    public ArrayList<Friendship> getAll() throws SQLException {
        return this.friendshipRepository.getAll();
    }

}
