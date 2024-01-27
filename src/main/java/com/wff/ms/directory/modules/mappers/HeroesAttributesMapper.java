package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.HeroesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesAttributesDto;
import com.wff.ms.directory.models.dto.update.HeroesAttributesUpdateDto;
import com.wff.ms.directory.models.entity.HeroesAttributes;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Маппер преобразующий сущность {@link HeroesAttributes}
 *
 * @author Orlov
 * @since 01.2024
 */
@Mapper
public interface HeroesAttributesMapper {

  HeroesAttributes heroesAttributesCreateDtoToHeroesAttributes(
      HeroesAttributesCreateDto heroesAttributesCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateHeroesAttributes(
      HeroesAttributesUpdateDto heroesAttributesUpdateDto,
      @MappingTarget HeroesAttributes heroesAttributes);

  HeroesAttributesDto heroesAttributesToHeroesAttributesDto(HeroesAttributes heroesAttributes);
}
