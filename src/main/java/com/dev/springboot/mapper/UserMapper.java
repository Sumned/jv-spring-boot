package com.dev.springboot.mapper;

import com.dev.springboot.dto.user.UserRequestDto;
import com.dev.springboot.dto.user.UserResponseDto;
import com.dev.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto getUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getEmail());
    }

    public User getUserFromRequestDto(UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
