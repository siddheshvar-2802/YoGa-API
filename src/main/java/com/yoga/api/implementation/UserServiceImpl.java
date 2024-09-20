package com.yoga.api.implementation;

import com.yoga.api.entity.User;
import com.yoga.api.exception.InvalidUserRequestException;
import com.yoga.api.exception.UserAlreadyExistsException;
import com.yoga.api.repository.UserRepository;
import com.yoga.api.request.UserRequest;
import com.yoga.api.response.UserResponse;
import com.yoga.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserRequest userRequest) {
        try {

            User userPhone = userRepository.findByIsActiveAndPhoneNo(true, userRequest.getPhoneNo());
            if (userPhone != null) {
                throw new UserAlreadyExistsException("User already exists with phone number: " + userRequest.getPhoneNo());
            }

            User userEmail = userRepository.findByIsActiveAndEmailId(true, userRequest.getEmailId());
            if (userEmail != null) {
                throw new UserAlreadyExistsException("User already exists with email id: " + userRequest.getEmailId());
            }

            if (userRequest.getUserName() == null || userRequest.getUserName().isEmpty()) {
                throw new InvalidUserRequestException("User name cannot be empty");
            }

            User newUser = new User();
            newUser.setUserName(userRequest.getUserName());
            newUser.setPhoneNo(userRequest.getPhoneNo());
            newUser.setEmailId(userRequest.getEmailId());
            newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            newUser.setIsAdmin(false);
            newUser.setIsActive(true);

            return userRepository.save(newUser);
        } catch (UserAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
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
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
