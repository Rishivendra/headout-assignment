package com.headout.assignment.headout.repository;

import com.headout.assignment.headout.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private final Map<String, UserModel> users = new HashMap<>();

    public boolean exists(String username) {
        return users.containsKey(username);
    }

    public UserModel save(UserModel user) {
        users.put(user.getUsername(), user);
        return user;
    }

    public UserModel findByUsername(String username) {
        return users.get(username);
    }
}