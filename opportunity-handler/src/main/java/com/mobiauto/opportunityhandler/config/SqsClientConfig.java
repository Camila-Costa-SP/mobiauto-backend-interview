package com.mobiauto.opportunityhandler.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Configuration
public class SqsClientConfig {

    @Value("${localstack.url:https://localhost.localstack.cloud:4566}")
    //@Value("${https://localhost.localstack.cloud:4566")
    private String localStackUrl;

    @Bean
    public SqsClient sqsClient(){
        return SqsClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test")))
                .endpointOverride(URI.create(localStackUrl))  // Override AWS default endpoint
                .region(Region.US_EAST_1)
                .build();
    }
}
