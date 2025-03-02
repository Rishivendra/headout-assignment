package com.headout.assignment.headout.service.impl;

import com.headout.assignment.headout.model.UserModel;
import com.headout.assignment.headout.repository.UserRepository;
import com.headout.assignment.headout.request.UserRequest;
import com.headout.assignment.headout.response.UserResponse;
import com.headout.assignment.headout.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse registerUser(UserRequest request) {
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username is required.");
        }
        if (userRepository.exists(request.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }
        UserModel user = new UserModel(request.getUsername());
        userRepository.save(user);
        UserResponse response = UserResponse.builder()
                .username(user.getUsername())
                .score(user.getScore())
                .build();
        log.info("User registered successfully. Request: {}, Response: {}", request, response);
        return response;
    }

    @Override
    public UserResponse getUser(UserRequest request) {
        UserModel user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("User not found.");
        }
        UserResponse response = UserResponse.builder()
                .username(user.getUsername())
                .score(user.getScore())
                .build();
        log.info("User retrieved successfully. Request: {}, Response: {}", request, response);
        return response;
    }

    @Override
    public void updateUserScore(String username, boolean correct) {
        UserModel user = userRepository.findByUsername(username);
        if (user != null) {
            int newScore = user.getScore() + (correct ? 1 : 0);
            user.setScore(newScore);
            userRepository.save(user);
            log.info("Updated score for user {}: new score {}", username, newScore);
        }
    }

}
