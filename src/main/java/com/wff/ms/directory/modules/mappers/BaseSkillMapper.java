package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.BaseSkillCreateDto;
import com.wff.ms.directory.models.dto.response.BaseSkillsDto;
import com.wff.ms.directory.models.dto.update.BaseSkillUpdateDto;
import com.wff.ms.directory.models.entity.BaseSkill;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface BaseSkillMapper {
  BaseSkill baseSkillCreateDtoToBaseSkill(BaseSkillCreateDto baseSkillCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateBaseSkill(BaseSkillUpdateDto baseSkillUpdateDto, @MappingTarget BaseSkill baseSkill);

  BaseSkillsDto baseSkillToBaseSkillDto(BaseSkill baseSkill);
}
