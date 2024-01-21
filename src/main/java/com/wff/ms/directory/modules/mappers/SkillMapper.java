package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.SkillCreateDto;
import com.wff.ms.directory.models.dto.SkillGetDto;
import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {
  public Skill mapToModel(SkillCreateDto dto) {
    Skill skill = new Skill();
    skill.setName(dto.getName());
    skill.setDescription(dto.getDescription());
    return skill;
  }

  public SkillGetDto mapToGetDto(Skill skill) {
    return new SkillGetDto(skill.getName(), skill.getDescription());
  }

  public Skill mapToModel(SkillUpdateDto dto) {
    Skill skill = new Skill();
    skill.setId(dto.getId());
    skill.setName(dto.getUpdatedInfo().getName());
    skill.setDescription(dto.getUpdatedInfo().getDescription());
    return skill;
  }
}
