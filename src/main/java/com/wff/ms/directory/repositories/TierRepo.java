package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TierRepo extends JpaRepository<Tier, Integer> {}