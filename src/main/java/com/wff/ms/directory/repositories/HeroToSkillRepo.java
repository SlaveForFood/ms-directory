package com.wff.ms.directory.repositories;

import com.wff.ms.directory.models.entity.HeroToSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroToSkillRepo extends JpaRepository<HeroToSkill,Integer> {

}
