package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.create.ArtifactsAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactsAttributesDto;
import com.wff.ms.directory.models.dto.update.ArtifactsAttributesUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactsAttributes;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Маппер преобразующий сущность {@link ArtifactsAttributes}
 *
 * @author Orlov
 * @since 01.2024
 */
@Mapper
public interface ArtifactsAttributesMapper {

  ArtifactsAttributes artifactsAttributesCreateDtoToArtifactsAttributes(
      ArtifactsAttributesCreateDto artifactsAttributesCreateDto);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateArtifactsAttributes(
      ArtifactsAttributesUpdateDto artifactsAttributesUpdateDto,
      @MappingTarget ArtifactsAttributes artifactsAttributes);

  ArtifactsAttributesDto artifactsAttributesToArtifactsAttributesDto(
      ArtifactsAttributes artifactsAttributes);
}
