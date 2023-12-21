package com.book.onlinestore.controller;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.UserDto;
import com.book.onlinestore.dto.UserDtoResponse;
import com.book.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired(required = false)
  private UserService userService;


    // Create a new user
    @PostMapping("/register")
    public ResponseEntity<UserDtoResponse> RegisterUser(@RequestBody UserDto user) {
        var createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Get all users
    @GetMapping("/viewUsers")
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        var users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get user by ID
    @GetMapping("/getUserBy/{userId}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long userId) {
        var user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(user.getStatusCode()));
    }

}
