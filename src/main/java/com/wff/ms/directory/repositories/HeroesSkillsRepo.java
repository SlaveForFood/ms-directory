package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.HeroesSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesSkillsRepo extends JpaRepository<HeroesSkills,Integer> {

}
