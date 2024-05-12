package com.mobiauto.auth.service.impl;

import com.mobiauto.auth.exceptions.UserNotFoundException;
import com.mobiauto.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mobiauto.auth.enums.ErrorType.USER_NOT_FOUND;

@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    public boolean canCreateUser(Jwt jwt, Set<Long> requestedResaleIds) {
        List<String> authorizedResaleIds = jwt.getClaimAsStringList("resales");
        return requestedResaleIds.stream()
                .allMatch(id -> authorizedResaleIds.contains(String.valueOf(id)));
    }
    public boolean canUpdateUser(Jwt jwt, Long userId) {
        List<String> userResales = jwt.getClaimAsStringList("resales");
        var user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        return user.getResaleIds().stream()
                .anyMatch(resaleId -> userResales.contains(resaleId.toString()));
    }
}