package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.models.entity.HeroesToSkills;

import java.util.List;

public interface HeroesToSkillsService {
    void create(HeroesToSkills heroesToSkills);
    List<HeroesToSkills> getAll();
    HeroesToSkills get(Integer id);
    HeroesToSkills update();
    boolean delete(Integer id);
}
