package com.mobiauto.opportunities.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiauto.opportunities.dto.OpportunityDTO;
import com.mobiauto.opportunities.dto.OpportunityMessageDTO;
import com.mobiauto.opportunities.dto.OpportunityRequestDTO;
import com.mobiauto.opportunities.entity.Client;
import com.mobiauto.opportunities.entity.Opportunity;
import com.mobiauto.opportunities.entity.ProductInterest;
import com.mobiauto.opportunities.enums.OpportunityStatus;
import com.mobiauto.opportunities.exception.ClientNotFoundException;
import com.mobiauto.opportunities.exception.OpportunityNotFoundException;
import com.mobiauto.opportunities.exception.ProductInterestNotFoundException;
import com.mobiauto.opportunities.mappers.OpportunityMapper;
import com.mobiauto.opportunities.repository.ClientRepository;
import com.mobiauto.opportunities.repository.OpportunityRepository;
import com.mobiauto.opportunities.repository.ProductInterestRepository;
import com.mobiauto.opportunities.service.OpportunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductInterestRepository productInterestRepository;
    @Autowired
    private OpportunityMapper opportunityMapper;

    @Autowired
    private SqsMessageSender sqsMessageSender;

    @Transactional
    public OpportunityDTO createOpportunity(final OpportunityRequestDTO request) {
        var client = findClient(request);

        var productInterest = findProductInterest(request);

        var opportunity = new Opportunity();
        setOpportunity(request, opportunity, client, productInterest);
        opportunity.setCreationDate(LocalDateTime.now());

        opportunityRepository.save(opportunity);

        ObjectMapper objectMapper = new ObjectMapper();

        OpportunityMessageDTO message = new OpportunityMessageDTO(
                opportunity.getId(),
                client.getId(),
                productInterest.getId(),
                opportunity.getStatus(),
                opportunity.getResaleId()
        );

        try {
            String messageBody = objectMapper.writeValueAsString(message);
            sqsMessageSender.sendMessage(messageBody);
        } catch (Exception e) {
            log.error("Error serializing or sending message opportunity: {} ", e.getMessage());
        }

        return opportunityMapper.toOpportunityDTO(opportunity);
    }

    public OpportunityDTO getOpportunity(final Long id) {
        var opportunity = findOpportunity(id);
        return opportunityMapper.toOpportunityDTO(opportunity);
    }

    @Transactional
    public OpportunityDTO updateOpportunity(final Long id, final OpportunityRequestDTO request) {
        var opportunity = findOpportunity(id);

        var client = findClient(request);

        var productInterest = findProductInterest(request);

        setOpportunity(request, opportunity, client, productInterest);
        opportunity.setUpdateDate(LocalDateTime.now());

        opportunityRepository.save(opportunity);
        return opportunityMapper.toOpportunityDTO(opportunity);
    }

    @Transactional
    public OpportunityDTO updateOpportunityStatus(final Long id, final String status) {
        var opportunity = findOpportunity(id);

        var statusEnum = OpportunityStatus.valueOf(status.toUpperCase());
        opportunity.setStatus(statusEnum.name());
        opportunity.setUpdateDate(LocalDateTime.now());

        opportunityRepository.save(opportunity);
        return opportunityMapper.toOpportunityDTO(opportunity);
    }

    private Client findClient(final OpportunityRequestDTO request) {
        return clientRepository.findById(request.clientId())
                .orElseThrow(ClientNotFoundException::new);
    }

    private Opportunity findOpportunity(final Long id) {
        return opportunityRepository.findById(id)
                .orElseThrow(OpportunityNotFoundException::new);
    }

    private ProductInterest findProductInterest(final OpportunityRequestDTO request) {
        return productInterestRepository.findById(request.productInterestId())
                .orElseThrow(ProductInterestNotFoundException::new);
    }

    private static void setOpportunity(final OpportunityRequestDTO request,
                                       final Opportunity opportunity,
                                       final Client client,
                                       final ProductInterest productInterest) {
        opportunity.setClient(client);
        opportunity.setProductInterest(productInterest);
        opportunity.setStatus(request.status());
        opportunity.setResaleId(request.resaleId());

    }
}