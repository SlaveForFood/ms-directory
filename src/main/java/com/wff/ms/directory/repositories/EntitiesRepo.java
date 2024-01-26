package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.Entiti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitiesRepo extends JpaRepository<Entiti, Integer> {}
