package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.EntitiesSkillsCreateDto;
import com.wff.ms.directory.models.dto.EntitiesSkillsGetDto;
import com.wff.ms.directory.models.dto.update.EntitiesSkillsUpdateDto;
import com.wff.ms.directory.models.entity.EntitiesSkills;
import org.springframework.stereotype.Component;

@Component
public class EntitiesSkillsMapper {

  public EntitiesSkills mapToModel(EntitiesSkillsCreateDto dto) {
    EntitiesSkills entitiesSkills = new EntitiesSkills();
    entitiesSkills.setSkills(dto.getSkills());
    return entitiesSkills;
  }

  public EntitiesSkillsGetDto mapToGetModel(EntitiesSkills entitiesSkills) {
    return new EntitiesSkillsGetDto(entitiesSkills.getSkills());
  }

  public EntitiesSkills mapToModel(EntitiesSkillsUpdateDto dto) {
    EntitiesSkills entitiesSkills = new EntitiesSkills();
    entitiesSkills.setId(dto.getId());
    entitiesSkills.setSkills(dto.getUpdatedInfo().getSkills());
    return entitiesSkills;
  }
}
