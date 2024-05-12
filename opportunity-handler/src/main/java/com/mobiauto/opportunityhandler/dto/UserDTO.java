package com.mobiauto.opportunityhandler.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
    Set<Long> resaleIds;

}