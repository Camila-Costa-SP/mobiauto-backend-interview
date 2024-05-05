package com.mobiauto.auth.service.impl;

import com.mobiauto.auth.config.JwtTokenProvider;
import com.mobiauto.auth.dto.AuthResponseDto;
import com.mobiauto.auth.dto.LoginDto;
import com.mobiauto.auth.entity.UserEntity;
import com.mobiauto.auth.exceptions.InvalidEmailException;
import com.mobiauto.auth.exceptions.InvalidPasswordException;
import com.mobiauto.auth.repository.UserRepository;
import com.mobiauto.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthResponseDto authenticateUser(final LoginDto loginDto) {

        UserEntity user = userRepository.findByEmail(loginDto.email())
                .orElseThrow(InvalidEmailException::new);

        if (!passwordEncoder.matches(loginDto.password(), user.getPassword())) {
            throw new InvalidPasswordException();
        }

        String token = jwtTokenProvider.createToken(user.getEmail(), user.getId(), user.getRole());

        return new AuthResponseDto(token, user.getUsername(), user.getRole());

    }
}