package com.mobiauto.auth.service;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.enums.Roles;

import java.util.List;

public interface UserService {
    UserDto createUser(final UserRequestDto userRequestDto);

    UserDto updateUser(final Long userId, final UserRequestDto userRequest);

    UserDto getUserById(final Long userId);

    void deleteUser(final Long userId);

    UserDto getUserByEmail(String email);

    List<UserDto> findByRoleAndResaleId(Roles role, Long resaleId);
}
