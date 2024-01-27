package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.ArtifactsAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactsAttributesDto;
import com.wff.ms.directory.models.dto.update.ArtifactsAttributesUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactsAttributes;
import com.wff.ms.directory.modules.mappers.ArtifactsAttributesMapper;
import com.wff.ms.directory.repositories.ArtifactRepo;
import com.wff.ms.directory.repositories.ArtifactsAttributesRepo;
import com.wff.ms.directory.repositories.AttributeRepo;
import com.wff.ms.directory.services.ArtifactsAttributesService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация интерфейса {@link ArtifactsAttributesService}
 *
 * @author Orlov
 * @since 01.2024
 */
@Service
@RequiredArgsConstructor
public class ArtifactsAttributesServiceImpl implements ArtifactsAttributesService {

  private final ArtifactsAttributesRepo artifactsAttributesRepo;
  private final ArtifactsAttributesMapper artifactsAttributesMapper;
  private final ArtifactRepo artifactRepo;
  private final AttributeRepo attributeRepo;

  @Override
  public ArtifactsAttributesDto create(ArtifactsAttributesCreateDto artifactsAttributesCreateDto) {
    ArtifactsAttributes artifactsAttributes =
        artifactsAttributesMapper.artifactsAttributesCreateDtoToArtifactsAttributes(
            artifactsAttributesCreateDto);
    var artifact =
        artifactRepo
            .findById(artifactsAttributesCreateDto.getArtifactId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an ArtifactsAttributes with artifact not exist. artifactId: %d"
                            .formatted(artifactsAttributesCreateDto.getArtifactId())));
    var attribute =
        attributeRepo
            .findById(artifactsAttributesCreateDto.getAttributeId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an artifact with type not exist. attributeId: %d"
                            .formatted(artifactsAttributesCreateDto.getAttributeId())));
    artifactsAttributes.setArtifact(artifact);
    artifactsAttributes.setAttribute(attribute);
    artifactsAttributes = artifactsAttributesRepo.save(artifactsAttributes);
    return artifactsAttributesMapper.artifactsAttributesToArtifactsAttributesDto(
        artifactsAttributes);
  }

  @Override
  public List<ArtifactsAttributesDto> getAll() {
    return artifactsAttributesRepo.findAll().stream()
        .map(artifactsAttributesMapper::artifactsAttributesToArtifactsAttributesDto)
        .toList();
  }

  @Override
  public ArtifactsAttributesDto getById(Integer id) {
    return artifactsAttributesMapper.artifactsAttributesToArtifactsAttributesDto(findById(id));
  }

  @Override
  public ArtifactsAttributesDto update(ArtifactsAttributesUpdateDto artifactsAttributesUpdateDto) {
    Integer artifactsAttributesId = artifactsAttributesUpdateDto.getId();
    ArtifactsAttributes artifactsAttributes = findById(artifactsAttributesId);
    Integer artifactId = artifactsAttributesUpdateDto.getArtifactId();
    if (Objects.nonNull(artifactId)) {
      var artifact =
          artifactRepo
              .findById(artifactId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an ArtifactsAttributes with artifact not exist. ArtifactsAttributes id: %d, artifactId: %d"
                              .formatted(artifactsAttributesId, artifactId)));
      artifactsAttributes.setArtifact(artifact);
    }
    Integer attributeId = artifactsAttributesUpdateDto.getAttributeId();
    if (Objects.nonNull(attributeId)) {
      var attribute =
          attributeRepo
              .findById(attributeId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an ArtifactsAttributes with attribute not exist. ArtifactsAttributes id: %d, attributeId: %d"
                              .formatted(artifactsAttributesId, attributeId)));
      artifactsAttributes.setAttribute(attribute);
    }
    artifactsAttributesMapper.updateArtifactsAttributes(
        artifactsAttributesUpdateDto, artifactsAttributes);
    artifactsAttributesRepo.save(artifactsAttributes);
    return artifactsAttributesMapper.artifactsAttributesToArtifactsAttributesDto(
        artifactsAttributes);
  }

  @Override
  public void deleteById(Integer id) {
    artifactsAttributesRepo.delete(findById(id));
  }

  private ArtifactsAttributes findById(Integer id) {
    return artifactsAttributesRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "ArtifactsAttributes doesn't found while searching by id: %d".formatted(id)));
  }
}
