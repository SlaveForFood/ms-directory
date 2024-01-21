package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.FactionToBaseSkill;
import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.services.FactionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionToBaseSkillRepo extends JpaRepository<FactionToBaseSkill,Integer> {

}
