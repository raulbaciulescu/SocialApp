package com.example.socialapp.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Friendship extends Entity<Long> {
    private LocalDateTime creationDate;
    private Tuple<User, User> users;


    public Friendship(Tuple<User, User> users) {
        this.users = users;
    }

    public Tuple<User, User> getUsers() {
        return users;
    }

    public void setUsers(Tuple<User, User> users) {
        this.users = users;
    }

    public User getFirstUser() {
        return users.first();
    }

    public User getSecondUser() {
        return users.second();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(creationDate, that.creationDate) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), creationDate, users);
    }
}
