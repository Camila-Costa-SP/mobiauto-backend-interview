package com.mobiauto.auth.controller;

import com.mobiauto.auth.controller.spec.JobUserApi;
import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.enums.Roles;
import com.mobiauto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobUserController implements JobUserApi {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<UserDto>> getUsersByRoleAndResale(final Roles role, final Long resaleId) {
        return ResponseEntity.ok(userService.findByRoleAndResaleId(role, resaleId));
    }
}
