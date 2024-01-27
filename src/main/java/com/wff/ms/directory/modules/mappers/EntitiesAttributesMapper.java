package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.EntitiesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.AttributeDto;
import com.wff.ms.directory.models.dto.response.EntitiesAttributesDto;
import com.wff.ms.directory.models.dto.response.EntitiDto;
import com.wff.ms.directory.models.dto.update.EntitiesAttributesUpdateDto;
import com.wff.ms.directory.models.entity.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface EntitiesAttributesMapper {

  EntitiesAttributes entitiesAttributesCreateDtoToEntitiesAttributes(
      EntitiesAttributesCreateDto entitiesAttributesCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateEntitiesAttributes(
      EntitiesAttributesUpdateDto entitiesAttributesUpdateDto,
      @MappingTarget EntitiesAttributes entitiesAttributes);

  EntitiesAttributesDto entitiesAttributesToEntitiesAttributesDto(
      EntitiesAttributes entitiesAttributes);

  EntitiDto entitiesToEntitiesDto(Entiti entiti);

  AttributeDto attributeToAttributeDto(Attribute attribute);
}
