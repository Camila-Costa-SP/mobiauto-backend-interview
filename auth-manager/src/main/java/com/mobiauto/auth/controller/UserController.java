package com.mobiauto.auth.controller;
import com.mobiauto.auth.controller.spec.UserApi;
import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.enums.Roles;
import com.mobiauto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    public ResponseEntity<UserDto> createUser(final UserRequestDto userRequestDto) {
        return ResponseEntity.ok(userService.createUser(userRequestDto));
    }

    public ResponseEntity<UserDto> updateUser(final Long userId, final UserRequestDto userRequest) {
        return ResponseEntity.ok(userService.updateUser(userId, userRequest));
    }

    public ResponseEntity<UserDto> getUser(final Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    public ResponseEntity<UserDto> getUserByEmail(final String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    public ResponseEntity<Void> deleteUser(final Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<List<UserDto>> getUsersByRoleAndResale(final Roles role, final Long resaleId) {
        return ResponseEntity.ok(userService.findByRoleAndResaleId(role, resaleId));
    }
}