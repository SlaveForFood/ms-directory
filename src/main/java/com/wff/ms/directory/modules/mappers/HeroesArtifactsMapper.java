package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.HeroesArtifactsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesArtifactsDto;
import com.wff.ms.directory.models.dto.update.HeroesArtifactsUpdateDto;
import com.wff.ms.directory.models.entity.HeroesArtifacts;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Маппер преобразующий сущность {@link HeroesArtifacts}
 *
 * @author Orlov
 * @since 01.2024
 */
@Mapper
public interface HeroesArtifactsMapper {
  HeroesArtifacts heroesArtifactsCreateDtoToHeroesArtifacts(
      HeroesArtifactsCreateDto heroesArtifactsCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateHeroesArtifacts(
      HeroesArtifactsUpdateDto heroesArtifactsUpdateDto,
      @MappingTarget HeroesArtifacts heroesArtifacts);

  HeroesArtifactsDto heroesArtifactsToHeroesArtifactsDto(HeroesArtifacts heroesArtifacts);
}
