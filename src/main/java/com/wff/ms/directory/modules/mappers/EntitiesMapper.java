package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.EntitiesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesDto;
import com.wff.ms.directory.models.dto.response.TierDto;
import com.wff.ms.directory.models.dto.update.EntitiesUpdateDto;
import com.wff.ms.directory.models.entity.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface EntitiesMapper {

    Entities entitiesCreateDtoToEntities(EntitiesCreateDto entitiesCreateDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntities(EntitiesUpdateDto entitiesUpdateDto, @MappingTarget Entities entities);

    EntitiesDto entitiesToEntitiesDto(Entities entities);

    TierDto tierToTierDto(Tier tier);

}


