package com.book.onlinestore.service;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.UserDto;
import com.book.onlinestore.dto.UserDtoResponse;
import com.book.onlinestore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
  UserDtoResponse addUser(UserDto userDto);
  List<UserDtoResponse> getAllUser();
  ApiResponse getUser(long UserId);
}
