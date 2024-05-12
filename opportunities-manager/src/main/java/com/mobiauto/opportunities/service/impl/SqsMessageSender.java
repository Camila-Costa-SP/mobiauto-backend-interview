package com.mobiauto.opportunities.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
public class SqsMessageSender {

    @Autowired
    private SqsAsyncClient sqsClient;
    @Value("${sqs.queue.url:https://localhost.localstack.cloud:4566/000000000000/devOpportunityQueue}")
    private String queueUrl;

    public void sendMessage(String messageBody) {
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(messageBody)
                .build();

        sqsClient.sendMessage(sendMsgRequest).join();
    }
}
