package com.mobiauto.opportunityhandler.service.impl;

import com.mobiauto.opportunityhandler.dto.OpportunityMessageDTO;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SqsMessageProcessor {
    @Autowired
    private SqsClient sqsClient;
    @Autowired
    private OpportunityAssignmentAutomatedService assignmentService;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String queueUrl = "http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/devOpportunityQueue";
    @Scheduled(fixedDelay = 10000)
    public void processMessages() {
        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .waitTimeSeconds(20)
                .build();

        ReceiveMessageResponse response = sqsClient.receiveMessage(request);
        for (Message message : response.messages()) {
            try {
                OpportunityMessageDTO opportunity = objectMapper.readValue(message.body(), OpportunityMessageDTO.class);
                assignmentService.assignOpportunity(opportunity);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sqsClient.deleteMessage(builder -> builder.queueUrl(queueUrl).receiptHandle(message.receiptHandle()));
            }
        }
    }
}