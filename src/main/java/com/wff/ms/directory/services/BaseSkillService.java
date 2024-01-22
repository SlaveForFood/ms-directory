package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.update.BaseSkillUpdateDto;
import com.wff.ms.directory.models.entity.BaseSkill;


import java.util.List;

public interface BaseSkillService {
    void create(BaseSkill baseSkill);

    List<BaseSkill> getAll();

    BaseSkill getById(Integer id);

    BaseSkill update(BaseSkillUpdateDto baseSkillUpdateDto);

    void delete(Integer id);
}
