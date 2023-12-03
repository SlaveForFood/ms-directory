package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.HeroToSkill;

import java.util.List;

public interface HeroesToSkillsService {
    void create(HeroToSkill heroToSkill);
    List<HeroToSkill> getAll();
    HeroToSkill getById(Integer id);
    String update(HeroToSkill heroToSkill);
    boolean delete(Integer id);
}
