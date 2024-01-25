package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.response.HeroToSkillDto;
import com.wff.ms.directory.models.dto.create.HeroToSkillCreateDto;
import com.wff.ms.directory.models.dto.update.HeroToSkillUpdateDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

import com.wff.ms.directory.models.entity.HeroToSkill;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface HeroToSkillMapper{
    HeroToSkill mapToModel(HeroToSkillCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHeroToSkill(HeroToSkillUpdateDto dto, @MappingTarget HeroToSkill heroToSkill);

    HeroToSkillDto mapToEntity(HeroToSkill heroToSkill);
}
