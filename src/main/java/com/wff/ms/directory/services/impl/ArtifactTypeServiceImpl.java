package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.AlreadyExistException;
import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.response.ArtifactTypeDto;
import com.wff.ms.directory.models.dto.update.ArtifactTypeUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactType;
import com.wff.ms.directory.modules.mappers.ArtifactMapper;
import com.wff.ms.directory.repositories.ArtifactTypeRepo;
import com.wff.ms.directory.services.ArtifactTypeService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация сервиса {@link ArtifactTypeService}
 *
 * @author Orlov
 * @since 01.2024
 */
@Service
@RequiredArgsConstructor
public class ArtifactTypeServiceImpl implements ArtifactTypeService {

  private final ArtifactTypeRepo artifactTypeRepo;
  private final ArtifactMapper artifactMapper;

  @Override
  public ArtifactTypeDto create(String name) {
    if (findByNameAnyCase(name).isPresent()) {
      throw new AlreadyExistException(
          "Can't create new artifact type. Type '%s' already exist.".formatted(name));
    }
    var type = ArtifactType.builder().name(name).build();
    type = artifactTypeRepo.save(type);
    return artifactMapper.artifactTypeToArtifactTypeDto(type);
  }

  @Override
  public List<ArtifactTypeDto> getAll() {
    return artifactTypeRepo.findAll().stream()
        .map(artifactMapper::artifactTypeToArtifactTypeDto)
        .toList();
  }

  @Override
  public ArtifactTypeDto getById(Integer id) {
    return artifactMapper.artifactTypeToArtifactTypeDto(findById(id));
  }

  @Override
  public ArtifactTypeDto getByName(String name) {
    var artifact =
        findByNameAnyCase(name)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Artifact type doesn't found while searching by name: %s".formatted(name)));
    return artifactMapper.artifactTypeToArtifactTypeDto(artifact);
  }

  @Override
  public ArtifactTypeDto update(ArtifactTypeUpdateDto artifactTypeUpdateDto) {
    var name = artifactTypeUpdateDto.getName();
    if (findByNameAnyCase(name).isPresent()) {
      throw new AlreadyExistException(
          "Can't update artifact type with id: %d. Type '%s' already exist."
              .formatted(artifactTypeUpdateDto.getId(), name));
    }
    ArtifactType baseType = findById(artifactTypeUpdateDto.getId());
    baseType.setName(name);
    baseType = artifactTypeRepo.save(baseType);
    return artifactMapper.artifactTypeToArtifactTypeDto(baseType);
  }

  @Override
  public void deleteById(Integer id) {
    artifactTypeRepo.delete(findById(id));
  }

  private ArtifactType findById(Integer id) {
    return artifactTypeRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Artifact type doesn't found while searching by id: %d".formatted(id)));
  }

  private Optional<ArtifactType> findByNameAnyCase(String name) {
    return artifactTypeRepo.findByNameLikeIgnoreCase(name);
  }
}
