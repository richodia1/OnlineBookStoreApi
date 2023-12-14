package com.book.onlinestore.service;

import com.book.onlinestore.dto.UserDto;
import com.book.onlinestore.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
  void AddUser(UserDto userDto);
  List<User> getAllUser();
  Optional<User> getUser(long UserId);
}
