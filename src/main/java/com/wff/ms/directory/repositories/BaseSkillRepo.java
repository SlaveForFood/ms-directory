package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.BaseSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseSkillRepo extends JpaRepository<BaseSkill, Integer> {}
