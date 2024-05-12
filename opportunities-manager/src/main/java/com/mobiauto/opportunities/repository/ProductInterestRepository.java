package com.mobiauto.opportunities.repository;

import com.mobiauto.opportunities.entity.ProductInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInterestRepository extends JpaRepository<ProductInterest, Long> {
}
