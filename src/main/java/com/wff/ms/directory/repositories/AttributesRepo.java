package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepo extends JpaRepository<Attributes, Integer> {}
