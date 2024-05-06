package com.mobiauto.opportunities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class OpportunitiesManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpportunitiesManagerApplication.class, args);
    }

}