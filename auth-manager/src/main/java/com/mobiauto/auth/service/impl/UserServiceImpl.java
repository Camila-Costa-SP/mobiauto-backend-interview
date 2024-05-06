package com.mobiauto.auth.service.impl;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.entity.UserEntity;
import com.mobiauto.auth.exceptions.UserNotFoundException;
import com.mobiauto.auth.exceptions.UserAlreadyExistsException;
import com.mobiauto.auth.mapper.UserMapper;
import com.mobiauto.auth.repository.UserRepository;
import com.mobiauto.auth.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public UserDto createUser(final UserRequestDto userRequest) {
        userRepository.findByEmail(userRequest.email()).ifPresent(existingUser -> {
            throw new UserAlreadyExistsException();
        });
        var user = userMapper.userDtoToEntity(userRequest);
        userRepository.save(user);
        return userMapper.userEntityToDto(user);
    }

    @Transactional
    @Override
    public UserDto updateUser(final Long userId, final UserRequestDto userRequest) {
        var userEntity = findUserById(userId);
        userMapper.updateUserEntity(userRequest, userEntity);
        userRepository.save(userEntity);
        return userMapper.userEntityToDto(userEntity);
    }

    @Override
    public UserDto getUserById(final Long userId) {
        var user = findUserById(userId);
        return userMapper.userEntityToDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return  userMapper.userEntityToDto(user);
    }

    @Transactional
    @Override
    public void deleteUser(final Long userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }

    private UserEntity findUserById(final Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}