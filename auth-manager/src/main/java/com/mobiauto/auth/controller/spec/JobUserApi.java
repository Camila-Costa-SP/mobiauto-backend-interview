package com.mobiauto.auth.controller.spec;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.enums.Roles;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@RequestMapping("/job/users")
@Tag(name = "Job Users")
public interface JobUserApi {
    @GetMapping("/by-role-and-resale")
    @Operation(summary = "Get users by role and resale ID")
    ResponseEntity<List<UserDto>> getUsersByRoleAndResale(@RequestParam Roles role, @RequestParam Long resaleId);
}