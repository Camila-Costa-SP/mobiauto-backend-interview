package com.mobiauto.resale.repository;

import com.mobiauto.resale.entity.ResaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResaleRepository extends JpaRepository<ResaleEntity, Long> {

    boolean existsByCnpj(String cnpj);
}
