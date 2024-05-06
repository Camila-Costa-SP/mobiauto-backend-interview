package com.mobiauto.opportunities.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "product_interest", schema = "opportunities")
public class ProductInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String version;

    private Integer yearModel;

    @OneToMany(mappedBy = "productInterest")
    private Set<Opportunity> opportunities = new HashSet<>();
}