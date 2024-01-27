package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.EntitiCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiDto;
import com.wff.ms.directory.models.dto.response.TierDto;
import com.wff.ms.directory.models.dto.update.EntitiUpdateDto;
import com.wff.ms.directory.models.entity.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface EntitiMapper {

  Entiti entitiesCreateDtoToEntities(EntitiCreateDto entitiCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntities(EntitiUpdateDto entitiUpdateDto, @MappingTarget Entiti entiti);

  EntitiDto entitiesToEntitiesDto(Entiti entiti);

  TierDto tierToTierDto(Tier tier);
}
