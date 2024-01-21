package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.EntitiesAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitiesAttributesRepo extends JpaRepository<EntitiesAttributes, Integer> {}
