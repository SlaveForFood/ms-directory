package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.HeroToSkillCreateDto;
import com.wff.ms.directory.models.dto.response.HeroToSkillDto;
import com.wff.ms.directory.models.dto.update.HeroToSkillUpdateDto;
import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.models.entity.HeroToSkill;

import java.util.List;

public interface HeroToSkillService {
    HeroToSkillDto create(HeroToSkillCreateDto heroToSkillCreateDto);
    List<HeroToSkillDto> getAll();
    HeroToSkillDto getById(Integer id);
    HeroToSkillDto update(HeroToSkillUpdateDto heroToSkillUpdateDto);
    void deleteById(Integer id);
}
