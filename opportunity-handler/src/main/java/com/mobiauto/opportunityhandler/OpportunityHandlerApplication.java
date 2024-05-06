package com.mobiauto.opportunityhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpportunityHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpportunityHandlerApplication.class, args);
    }
}