package com.yoga.api.implementation;

import com.yoga.api.entity.User;
import com.yoga.api.repository.UserRepository;
import com.yoga.api.request.UserRequest;
import com.yoga.api.response.UserResponse;
import com.yoga.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserRequest userRequest) {
        try {
            User user = new User();
            user.setUserName(userRequest.getUserName());
            user.setPhoneNo(userRequest.getPhoneNo());
            user.setEmailId(userRequest.getEmailId());
            user.setPassword(userRequest.getPassword());
            user.setIsAdmin(false);
            user.setIsActive(true);

            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserResponse> getAllUsers() {
        try {
            List<UserResponse> usersList = new ArrayList<>();
            List<User> users = userRepository.findByIsActive(true);
            for (User user : users) {
                UserResponse userResponse = new UserResponse();
                userResponse.setUserId(user.getUserId());
                userResponse.setUserName(user.getUserName());
                userResponse.setPhoneNo(user.getPhoneNo());
                userResponse.setEmailId(user.getEmailId());

                usersList.add(userResponse);
            }
            return usersList;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
