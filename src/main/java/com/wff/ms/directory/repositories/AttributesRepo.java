package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepo extends JpaRepository<Attribute, Integer> {}
