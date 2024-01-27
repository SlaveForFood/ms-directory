package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.HeroesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroDto;
import com.wff.ms.directory.models.dto.response.HeroesSkillsDto;
import com.wff.ms.directory.models.dto.response.SkillDto;
import com.wff.ms.directory.models.dto.update.HeroesSkillsUpdateDto;
import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.models.entity.HeroesSkills;
import com.wff.ms.directory.models.entity.Skill;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface HeroesSkillsMapper {
  HeroesSkills heroesSkillsCreateDtoToHeroesSkills(HeroesSkillsCreateDto dto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateHeroesSkills(HeroesSkillsUpdateDto dto, @MappingTarget HeroesSkills heroesSkills);

  HeroesSkillsDto heroesSkillToHeroesSkillsDto(HeroesSkills heroesSkills);

  HeroDto heroToHeroDto(Hero hero);

  SkillDto skillToSkillDto(Skill skill);
}
