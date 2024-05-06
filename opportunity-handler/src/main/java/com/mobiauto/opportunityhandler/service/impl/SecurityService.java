package com.mobiauto.opportunityhandler.service.impl;

import com.mobiauto.opportunityhandler.client.UserManagerClient;
import com.mobiauto.opportunityhandler.dto.UserDTO;
import com.mobiauto.opportunityhandler.repository.OpportunityAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private static final String AUTHORIZATION_PREFIX = "Bearer ";
    private static final String USER_NOT_FOUND_ERROR = "User not found";
    private static final String ROLE_ASSISTANT = "ASSISTANT";

    @Autowired
    private UserManagerClient userManagerClient;

    @Autowired
    private OpportunityAssignmentRepository assignmentRepository;

    public boolean canAccessAssignment(Jwt jwt, Long assignmentId) {
        String email = jwt.getClaimAsString("sub");
        String authToken = AUTHORIZATION_PREFIX + jwt.getTokenValue();

        UserDTO user = userManagerClient.getUserByEmail(email, authToken)
                .orElseThrow(() -> new RuntimeException(USER_NOT_FOUND_ERROR));

        boolean isAdmin = user.getRole().contains(ROLE_ASSISTANT);
        if (isAdmin) {
            return userHasAccessToAssignment(user.getId(), assignmentId);
        }
        return true;
    }

    public boolean userHasAccessToAssignment(Long userId, Long assignmentId) {
        return assignmentRepository.findOneByIdAndAssignedToUserId(assignmentId, userId).isPresent();
    }
}