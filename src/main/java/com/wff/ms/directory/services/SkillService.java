package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.SkillCreateDto;
import com.wff.ms.directory.models.dto.response.SkillDto;
import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import java.util.List;

public interface SkillService {

  SkillDto create(SkillCreateDto skillCreateDto);

  List<SkillDto> getAll();

  SkillDto getById(Integer id);

  SkillDto update(SkillUpdateDto skillUpdateDto);

  void deleteById(Integer id);
}
