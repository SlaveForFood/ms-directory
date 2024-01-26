package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.FactionCreateDto;
import com.wff.ms.directory.models.dto.response.FactionDto;
import com.wff.ms.directory.models.dto.update.FactionUpdateDto;
import com.wff.ms.directory.models.entity.Faction;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface FactionMapper {
  Faction factionCreateDtoToFaction(FactionCreateDto factionCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateFaction(FactionUpdateDto factionUpdateDto, @MappingTarget Faction faction);

  FactionDto factionToFactionDto(Faction faction);
}
