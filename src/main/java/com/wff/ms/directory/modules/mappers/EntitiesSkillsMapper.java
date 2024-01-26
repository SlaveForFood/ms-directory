package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.EntitiesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesSkillsDto;
import com.wff.ms.directory.models.dto.update.EntitiesSkillsUpdateDto;
import com.wff.ms.directory.models.entity.EntitiesSkills;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface EntitiesSkillsMapper {

  EntitiesSkills entitiesSkillsCreateDtoToEntitiesSkills(
      EntitiesSkillsCreateDto entitiesSkillsCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntitiesSkills(
      EntitiesSkillsUpdateDto entitiesSkillsUpdateDto,
      @MappingTarget EntitiesSkills entitiesSkills);

  EntitiesSkillsDto entitiesSkillsToEntitiesSkillsDto(EntitiesSkills entitiesSkills);
}
