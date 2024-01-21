package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.SkillDto;
import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.Skill;
import java.util.List;

public interface SkillService {

  SkillDto create(Skill skill);

  List<Skill> getAll();

  Skill getById(Integer id);

  Skill update(SkillUpdateDto skillUpdateDto);

  void deleteById(Integer id);
}
