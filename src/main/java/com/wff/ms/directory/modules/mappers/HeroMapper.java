package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.response.FactionDto;
import com.wff.ms.directory.models.dto.response.HeroDto;
import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import com.wff.ms.directory.models.entity.Faction;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

import com.wff.ms.directory.models.entity.Hero;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface HeroMapper {

    Hero heroCreateDtoToHero(HeroCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateHero(HeroUpdateDto dto, @MappingTarget Hero hero);

    HeroDto heroToHeroDto(Hero hero);

    FactionDto factionToFactionDto(Faction faction);
}
