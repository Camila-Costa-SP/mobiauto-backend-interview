package com.mobiauto.opportunityhandler.client;

import com.mobiauto.opportunityhandler.config.FeignClientConfig;
import com.mobiauto.opportunityhandler.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "userManagerClient", url = "http://localhost:8100",  configuration = FeignClientConfig.class)
public interface UserManagerClient {

    @GetMapping("/users")
    Optional<UserDTO> getUserByEmail(@RequestParam("email") String email,
                                     @RequestHeader("Authorization") String authToken);

}