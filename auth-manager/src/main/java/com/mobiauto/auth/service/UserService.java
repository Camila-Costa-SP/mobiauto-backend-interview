package com.mobiauto.auth.service;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;

public interface UserService {
    UserDto createUser(final UserRequestDto userRequestDto);

    UserDto updateUser(final Long userId, final UserRequestDto userRequest);

    UserDto getUserById(final Long userId);

    void deleteUser(final Long userId);

    UserDto getUserByUsername(String username);
}
