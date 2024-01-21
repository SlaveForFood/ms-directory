package com.wff.ms.directory.services;

import com.wff.ms.directory.models.entity.BaseSkill;
import com.wff.ms.directory.models.entity.Skill;

import java.util.List;

public interface BaseSkillService {
    void create(BaseSkill baseSkill);

    List<BaseSkill> getAll();

    BaseSkill getById(Integer id);

//    Skill update(SkillUpdateDto skillUpdateDto);

    void delete(Integer id);
}
