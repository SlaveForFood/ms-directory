package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.FactionToBaseSkill;
import com.wff.ms.directory.models.entity.Skill;

import java.util.List;

public interface FactionToBaseSkillService {
  void create(FactionToBaseSkill factionToBaseSkill);

  List<FactionToBaseSkill> getAll();

  FactionToBaseSkill getById(Integer id);

  //        Skill update(SkillUpdateDto skillUpdateDto);

  void delete(Integer id);
}
