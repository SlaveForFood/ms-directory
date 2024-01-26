package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.TierCreateDto;
import com.wff.ms.directory.models.dto.response.TierDto;
import com.wff.ms.directory.models.dto.update.TierUpdateDto;
import com.wff.ms.directory.models.entity.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface TierMapper {

    Tier tierCreateDtoToTier(TierCreateDto tierCreateDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTier(TierUpdateDto tierUpdateDto, @MappingTarget Tier tier);

    TierDto tierToTierDto(Tier tier);

}