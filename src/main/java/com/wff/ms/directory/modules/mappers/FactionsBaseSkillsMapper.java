package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.FactionsBaseSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.FactionsBaseSkillsDto;
import com.wff.ms.directory.models.dto.update.FactionsBaseSkillsUpdateDto;
import com.wff.ms.directory.models.entity.FactionsBaseSkills;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface FactionsBaseSkillsMapper {
  FactionsBaseSkills factionsBaseSkillsCreateDtoToFactionsBaseSkill(
      FactionsBaseSkillsCreateDto factionBaseSkillsCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateFactionBaseSkills(
      FactionsBaseSkillsUpdateDto factionBaseSkillsUpdateDto,
      @MappingTarget FactionsBaseSkills factionBaseSkills);

  FactionsBaseSkillsDto factionBaseSkillsToFactionBaseSkillsDto(
      FactionsBaseSkills factionBaseSkills);
}
