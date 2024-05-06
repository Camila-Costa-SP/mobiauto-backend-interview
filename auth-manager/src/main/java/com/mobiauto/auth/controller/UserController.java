package com.mobiauto.auth.controller;

import com.mobiauto.auth.controller.spec.UserApi;
import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    public ResponseEntity<UserDto> createUser(final UserRequestDto userRequestDto) {
        UserDto createdUser = userService.createUser(userRequestDto);
        return ResponseEntity.ok(createdUser);
    }

    public ResponseEntity<UserDto> updateUser(final Long userId, final UserRequestDto userRequest) {
        UserDto updatedUser = userService.updateUser(userId, userRequest);
        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<UserDto> getUser(final Long userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<UserDto> getUserByEmail(final String email) {
        UserDto user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Void> deleteUser(final Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}