package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.Faction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionRepo extends JpaRepository<Faction, Integer> {}
