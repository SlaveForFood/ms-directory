package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.AlreadyExistException;
import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.response.ArtifactClassDto;
import com.wff.ms.directory.models.dto.update.ArtifactClassUpdateDto;
import com.wff.ms.directory.models.entity.ArtifactClass;
import com.wff.ms.directory.modules.mappers.ArtifactMapper;
import com.wff.ms.directory.repositories.ArtifactClassRepo;
import com.wff.ms.directory.services.ArtifactClassService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация интерфейса {@link ArtifactClassService}
 *
 * @author Orlov
 * @since 01.2024
 */
@Service
@RequiredArgsConstructor
public class ArtifactClassServiceImpl implements ArtifactClassService {
  private final ArtifactClassRepo artifactClassRepo;
  private final ArtifactMapper artifactMapper;

  @Override
  public ArtifactClassDto create(String name) {
    if (findByNameAnyCase(name).isPresent()) {
      throw new AlreadyExistException(
          "Can't create new artifact class. Class '%s' already exist.".formatted(name));
    }
    var clazz = ArtifactClass.builder().name(name).build();
    clazz = artifactClassRepo.save(clazz);
    return artifactMapper.artifactClassToArtifactClassDto(clazz);
  }

  @Override
  public List<ArtifactClassDto> getAll() {
    return artifactClassRepo.findAll().stream()
        .map(artifactMapper::artifactClassToArtifactClassDto)
        .toList();
  }

  @Override
  public ArtifactClassDto getById(Integer id) {
    return artifactMapper.artifactClassToArtifactClassDto(findById(id));
  }

  @Override
  public ArtifactClassDto getByName(String name) {
    var artifact =
        findByNameAnyCase(name)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Artifact class doesn't found while searching by name: %s"
                            .formatted(name)));
    return artifactMapper.artifactClassToArtifactClassDto(artifact);
  }

  @Override
  public ArtifactClassDto update(ArtifactClassUpdateDto artifactClassUpdateDto) {
    var name = artifactClassUpdateDto.getName();
    if (findByNameAnyCase(name).isPresent()) {
      throw new AlreadyExistException(
          "Can't update artifact class with id: %d. Class '%s' already exist."
              .formatted(artifactClassUpdateDto.getId(), name));
    }
    ArtifactClass baseClass = findById(artifactClassUpdateDto.getId());
    baseClass.setName(name);
    baseClass = artifactClassRepo.save(baseClass);
    return artifactMapper.artifactClassToArtifactClassDto(baseClass);
  }

  @Override
  public void deleteById(Integer id) {
    artifactClassRepo.delete(findById(id));
  }

  private ArtifactClass findById(Integer id) {
    return artifactClassRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Artifact class doesn't found while searching by id: %d".formatted(id)));
  }

  private Optional<ArtifactClass> findByNameAnyCase(String name) {
    return artifactClassRepo.findByNameLikeIgnoreCase(name);
  }
}
