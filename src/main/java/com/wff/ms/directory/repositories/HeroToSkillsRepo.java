package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.HeroesToSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroToSkillsRepo extends JpaRepository<HeroesToSkills,Integer> {

}
