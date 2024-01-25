package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.response.HeroDto;
import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import org.mapstruct.Mapper;

import com.wff.ms.directory.models.entity.Hero;

@Mapper
public interface HeroMapper {

    Hero mapToModel(HeroCreateDto dto);

    Hero mapToModel(HeroUpdateDto dto);

    HeroDto mapToEntity(Hero hero);

}
