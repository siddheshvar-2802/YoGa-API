package com.yoga.api.controller;

import com.yoga.api.entity.User;
import com.yoga.api.request.UserRequest;
import com.yoga.api.response.UserResponse;
import com.yoga.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{baseUrl}/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> newUser(@RequestBody UserRequest userRequest) {
        try {
            User user = userService.createUser(userRequest);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while creating user",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUsers() throws Exception {
        try {
            List<UserResponse> users = userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while getting all users",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
