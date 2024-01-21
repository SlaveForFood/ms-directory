package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.ArtifactCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactDto;
import com.wff.ms.directory.models.dto.update.ArtifactUpdateDto;
import com.wff.ms.directory.models.entity.Artifact;
import com.wff.ms.directory.modules.mappers.ArtifactMapper;
import com.wff.ms.directory.repositories.ArtifactClassRepo;
import com.wff.ms.directory.repositories.ArtifactRepo;
import com.wff.ms.directory.repositories.ArtifactTypeRepo;
import com.wff.ms.directory.services.ArtifactService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Реализация интерфейса {@link ArtifactService}
 *
 * @author Orlov
 * @since 01.2024
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ArtifactServiceImpl implements ArtifactService {

  private final ArtifactRepo artifactRepo;
  private final ArtifactTypeRepo artifactTypeRepo;
  private final ArtifactClassRepo artifactClassRepo;
  private final ArtifactMapper artifactMapper;

  @Override
  public ArtifactDto create(ArtifactCreateDto artifactCreateDto) {
    log.info("Artifact creation started");
    Artifact artifact = artifactMapper.artifactCreateDtoToArtifact(artifactCreateDto);
    var type =
        artifactTypeRepo
            .findById(artifactCreateDto.getTypeId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an artifact with type not exist. typeId: %d"
                            .formatted(artifactCreateDto.getTypeId())));
    var clazz =
        artifactClassRepo
            .findById(artifactCreateDto.getClazzId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an artifact with class not exist. clazzId: %d"
                            .formatted(artifactCreateDto.getClazzId())));
    artifact.setType(type);
    artifact.setClazz(clazz);
    log.info("Successfully converted request to the new artifact");
    artifact = artifactRepo.save(artifact);
    log.info("Artifact successfully saved to the database with id: {}", artifact.getId());
    ArtifactDto artifactDto = artifactMapper.artifactToArtifactDto(artifact);
    log.info("Successfully converted new artifact to the response");
    return artifactDto;
  }

  @Override
  public List<ArtifactDto> getAll() {
    return artifactRepo.findAll().stream().map(artifactMapper::artifactToArtifactDto).toList();
  }

  @Override
  public ArtifactDto getById(Integer id) {
    log.info("Artifact searching by id: {}, successfully started.", id);
    Artifact artifact = findById(id);
    log.info("Artifact searching by id: {}, completed successfully.", id);
    var response = artifactMapper.artifactToArtifactDto(artifact);
    log.info("Successfully converted artifact to response with id: {}", id);
    return response;
  }

  @Override
  public ArtifactDto update(ArtifactUpdateDto artifactUpdateDto) {
    Integer id = artifactUpdateDto.getId();
    log.info("Artifact update started for request with id: {}", id);
    Artifact artifact = findById(id);
    log.info("Artifact with id: {} exists and successfully retrieved from the database", id);
    Integer typeId = artifactUpdateDto.getTypeId();
    if (Objects.nonNull(typeId)) {
      var type =
          artifactTypeRepo
              .findById(typeId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an artifact with type not exist. Artifact id: %d, typeId: %d"
                              .formatted(id, typeId)));
      artifact.setType(type);
    }
    Integer clazzId = artifactUpdateDto.getClazzId();
    if (Objects.nonNull(clazzId)) {
      var clazz =
          artifactClassRepo
              .findById(clazzId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an artifact with class not exist. Artifact id: %d, clazzId: %d"
                              .formatted(id, clazzId)));
      artifact.setClazz(clazz);
    }
    artifactMapper.updateArtifact(artifactUpdateDto, artifact);
    log.info("Successfully updated artifact data with id: {} without saving", id);
    Artifact updatedArtifact = artifactRepo.save(artifact);
    log.info("Successfully save updated artifact into the database with id: {}", id);
    var response = artifactMapper.artifactToArtifactDto(updatedArtifact);
    log.info("Successfully converted updated artifact to the response");
    return response;
  }

  @Override
  public void deleteById(Integer id) {
    artifactRepo.delete(findById(id));
    log.info("Successfully converted artifact to response with id: {}", id);
  }

  private Artifact findById(Integer id) {
    return artifactRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Artifact doesn't found while searching by id: %d".formatted(id)));
  }
}
