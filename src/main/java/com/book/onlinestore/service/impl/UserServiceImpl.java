package com.book.onlinestore.service.impl;

import com.book.onlinestore.dto.UserDto;
import com.book.onlinestore.model.Book;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.UserRepository;
import com.book.onlinestore.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void AddUser(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();
        User userEntity = modelMapper.map(userDto,User.class);
        userRepository.save(userEntity);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(long UserId) {
        return userRepository.findById(UserId);
    }
}
