package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.AttributeCreateDto;
import com.wff.ms.directory.models.dto.response.AttributeDto;
import com.wff.ms.directory.models.dto.update.AttributesUpdateDto;
import com.wff.ms.directory.models.entity.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface AttributeMapper {

    Attribute attributeCreateDtoToAttribute(AttributeCreateDto attributeCreateDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAttribute(AttributesUpdateDto attributesUpdateDto, @MappingTarget Attribute attribute);

    AttributeDto attributeToAttributeDto(Attribute attribute);

}