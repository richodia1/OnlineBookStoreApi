package com.book.onlinestore.service;

import com.book.onlinestore.dto.ApiResponse;
import com.book.onlinestore.dto.UserDto;
import com.book.onlinestore.dto.UserDtoResponse;
import com.book.onlinestore.model.User;
import com.book.onlinestore.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
 public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDtoResponse addUser(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();
        User userEntity = modelMapper.map(userDto,User.class);
        UserDtoResponse user=  modelMapper.map(userRepository.save(userEntity),UserDtoResponse.class );
        return user;
    }

    @Override
    public List<UserDtoResponse> getAllUser() {
        var allUsers = userRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<UserDtoResponse> rtnUsers = allUsers
                .stream()
                .map(user -> modelMapper.map(user, UserDtoResponse.class))
                .collect(Collectors.toList());
        return rtnUsers;
    }

    @Override
    public ApiResponse getUser(long UserId) {
try {
    Optional<User> user = userRepository.findById(UserId);
    if (user.get() == null) {
        return new ApiResponse(400, "No such user exist with Id :" + UserId, "");
    }

    ModelMapper modelMapper = new ModelMapper();
    UserDtoResponse rtnUser = modelMapper.map(user, UserDtoResponse.class);
    return new ApiResponse(200, "Success", rtnUser);

}catch (Exception ex){
    return new ApiResponse(400, "No user exist for user with Id :"+UserId, "");

    }

    }
}
