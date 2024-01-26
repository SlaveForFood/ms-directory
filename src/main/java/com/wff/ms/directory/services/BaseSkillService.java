package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.BaseSkillCreateDto;
import com.wff.ms.directory.models.dto.response.BaseSkillsDto;
import com.wff.ms.directory.models.dto.update.BaseSkillUpdateDto;
import java.util.List;

public interface BaseSkillService {
  BaseSkillsDto create(BaseSkillCreateDto baseSkillCreateDto);

  List<BaseSkillsDto> getAll();

  BaseSkillsDto getById(Integer id);

  BaseSkillsDto update(BaseSkillUpdateDto baseSkillUpdateDto);

  void deleteById(Integer id);
}
