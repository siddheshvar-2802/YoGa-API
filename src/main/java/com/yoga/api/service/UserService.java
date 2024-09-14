package com.yoga.api.service;

import com.yoga.api.entity.User;
import com.yoga.api.request.UserRequest;
import com.yoga.api.response.UserResponse;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();
}
