package com.mobiauto.auth.service.impl;

import com.mobiauto.auth.dto.UserDto;
import com.mobiauto.auth.dto.UserRequestDto;
import com.mobiauto.auth.entity.UserEntity;
import com.mobiauto.auth.enums.Roles;
import com.mobiauto.auth.exceptions.NotAuthorizedException;
import com.mobiauto.auth.exceptions.UserNotFoundException;
import com.mobiauto.auth.exceptions.UserAlreadyExistsException;
import com.mobiauto.auth.mapper.UserMapper;
import com.mobiauto.auth.repository.UserRepository;
import com.mobiauto.auth.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.mobiauto.auth.enums.ErrorType.ACCESS_DENIED_MESSAGE;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

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

        validateAdminRoleAssignment(userRequest);

        var user = userMapper.userDtoToEntity(userRequest);

        userRepository.save(user);
        return userMapper.userEntityToDto(user);
    }

    @Transactional
    @Override
    public UserDto updateUser(final Long userId, final UserRequestDto userRequest) {
        var userEntity = findUserById(userId);

        List<String> authorizedResaleIds = getAuthorizedResaleIds();

        validateAdminRoleAssignment(userRequest);

        validateUserResaleAccess(userRequest, authorizedResaleIds);

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

    @Override
    public List<UserDto> findByRoleAndResaleId(Roles role, Long resaleId) {
        var users = userRepository.findByRoleAndResaleIdsIn(role, Collections.singleton(resaleId));
        return users.stream().map(userMapper::userEntityToDto).toList();
    }

    private UserEntity findUserById(final Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    private static void validateUserResaleAccess(UserRequestDto userRequest, List<String> authorizedResaleIds) {
        if (!authorizedResaleIds.containsAll(
                userRequest.resaleIds().stream().map(String::valueOf).toList())) {
            throw new AccessDeniedException(ACCESS_DENIED_MESSAGE.getMessage());
        }
    }

    private static void validateAdminRoleAssignment(UserRequestDto userRequest) {
        if (userRequest.role() == Roles.ADMIN &&
                !getContext()
                        .getAuthentication()
                        .getAuthorities()
                        .contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            throw new NotAuthorizedException();
        }
    }

    private static List<String> getAuthorizedResaleIds() {
        var authentication = getContext().getAuthentication();
        var jwt = (Jwt) authentication.getPrincipal();
        var authorizedResaleIds = jwt.getClaimAsStringList("resales");
        return authorizedResaleIds;
    }
}