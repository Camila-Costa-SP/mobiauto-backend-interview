package com.mobiauto.auth.mapper;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity userDtoToEntity(UserRequestDto userRequestDto) {
        UserEntity user = new UserEntity();
        user.setUsername(userRequestDto.username());
        user.setEmail(userRequestDto.email());
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        user.setRole(userRequestDto.role());
        return user;
    }

    public UserDto userEntityToDto(UserEntity user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole());
    }

    public void updateUserEntity(UserRequestDto userRequest, UserEntity userEntity) {
        userEntity.setUsername(userRequest.username());
        userEntity.setEmail(userRequest.email());
        userEntity.setRole(userRequest.role());
    }
}