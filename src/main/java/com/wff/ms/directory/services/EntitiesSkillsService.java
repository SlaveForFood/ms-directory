package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.EntitiesSkills;

import java.util.List;

public interface EntitiesSkillsService {

    void create(EntitiesSkills entitiesSkills);

    List<EntitiesSkills> getAll();

    EntitiesSkills getById(Integer id);

    EntitiesSkills update();

    void deleteById(Integer id);
}
