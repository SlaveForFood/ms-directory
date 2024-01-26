package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.FactionsBaseSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.FactionsBaseSkillsDto;
import com.wff.ms.directory.models.dto.update.FactionsBaseSkillsUpdateDto;
import java.util.List;

public interface FactionsBaseSkillsService {
  FactionsBaseSkillsDto create(FactionsBaseSkillsCreateDto factionsBaseSkillsCreateDto);

  List<FactionsBaseSkillsDto> getAll();

  FactionsBaseSkillsDto getById(Integer id);

  FactionsBaseSkillsDto update(FactionsBaseSkillsUpdateDto factionsBaseSkillsUpdateDto);

  void deleteById(Integer id);
}
