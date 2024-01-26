package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.FactionsBaseSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionsBaseSkillsRepo extends JpaRepository<FactionsBaseSkills, Integer> {}
