package com.mobiauto.auth.entity;

import com.mobiauto.auth.enums.Roles;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "auth")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String username;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @ElementCollection
    @CollectionTable(name = "user_resales", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "resale_id")
    private Set<Long> resaleIds = new HashSet<>();
}