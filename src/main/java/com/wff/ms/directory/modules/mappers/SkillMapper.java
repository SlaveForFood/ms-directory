package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.SkillCreateDto;
import com.wff.ms.directory.models.dto.response.SkillDto;
import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.Skill;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
public interface SkillMapper {
  Skill skillCreateDtoToSkill(SkillCreateDto skillCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateSkill(SkillUpdateDto skillUpdateDto, @MappingTarget Skill skill);

  SkillDto skillToSkillDto(Skill skill);
}
