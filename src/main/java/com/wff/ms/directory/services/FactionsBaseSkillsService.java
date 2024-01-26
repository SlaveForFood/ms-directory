package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.update.FactionsBaseSkillsUpdateDto;
import com.wff.ms.directory.models.entity.FactionsBaseSkills;
import java.util.List;

public interface FactionsBaseSkillsService {
  void create(FactionsBaseSkills factionsBaseSkills);

  List<FactionsBaseSkills> getAll();

  FactionsBaseSkills getById(Integer id);

  String update(FactionsBaseSkillsUpdateDto factionsBaseSkillsUpdateDto);

  void delete(Integer id);
}
