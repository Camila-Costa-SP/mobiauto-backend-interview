package com.mobiauto.opportunities.repository;

import com.mobiauto.opportunities.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
}
