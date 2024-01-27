package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.BaseSkillCreateDto;
import com.wff.ms.directory.models.dto.response.BaseSkillDto;
import com.wff.ms.directory.models.dto.update.BaseSkillUpdateDto;
import java.util.List;

public interface BaseSkillService {
  BaseSkillDto create(BaseSkillCreateDto baseSkillCreateDto);

  List<BaseSkillDto> getAll();

  BaseSkillDto getById(Integer id);

  BaseSkillDto update(BaseSkillUpdateDto baseSkillUpdateDto);

  void deleteById(Integer id);
}
