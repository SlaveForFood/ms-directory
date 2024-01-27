package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.HeroesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesSkillsDto;
import com.wff.ms.directory.models.dto.update.HeroesSkillsUpdateDto;
import java.util.List;

public interface HeroesSkillsService {
  HeroesSkillsDto create(HeroesSkillsCreateDto heroesSkillsCreateDto);

  List<HeroesSkillsDto> getAll();

  HeroesSkillsDto getById(Integer id);

  HeroesSkillsDto update(HeroesSkillsUpdateDto heroesSkillsUpdateDto);

  void deleteById(Integer id);
}
