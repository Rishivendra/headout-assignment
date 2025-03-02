package com.headout.assignment.headout.service;

import com.headout.assignment.headout.request.UserRequest;
import com.headout.assignment.headout.response.UserResponse;

public interface IUserService {

    UserResponse registerUser(UserRequest request);

    UserResponse getUser(UserRequest request);

    void updateUserScore(String username, boolean correct);
}
