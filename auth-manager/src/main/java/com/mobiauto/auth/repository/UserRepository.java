package com.mobiauto.auth.repository;

import com.mobiauto.auth.entity.UserEntity;

import com.mobiauto.auth.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findByRoleAndResaleIdsIn(Roles role, Set<Long> resaleIds);


}