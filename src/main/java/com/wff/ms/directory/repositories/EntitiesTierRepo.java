package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.EntitiesTier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitiesTierRepo extends JpaRepository<EntitiesTier, Integer> {}