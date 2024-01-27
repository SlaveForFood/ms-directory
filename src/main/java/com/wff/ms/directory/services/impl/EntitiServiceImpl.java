package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.EntitiCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiDto;
import com.wff.ms.directory.models.dto.update.EntitiUpdateDto;
import com.wff.ms.directory.models.entity.Entiti;
import com.wff.ms.directory.modules.mappers.EntitiMapper;
import com.wff.ms.directory.repositories.*;
import com.wff.ms.directory.services.EntitiService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntitiServiceImpl implements EntitiService {

  private final EntitiRepo entitiRepo;
  private final TierRepo tierRepo;
  private final EntitiMapper entitiMapper;

  @Override
  public EntitiDto create(EntitiCreateDto entitiCreateDto) {
    log.info("Entiti creation started");
    Entiti entiti = entitiMapper.entitiesCreateDtoToEntities(entitiCreateDto);
    var tier =
        tierRepo
            .findById(entitiCreateDto.getTierId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an entiti with tier not exist. typeId: %d"
                            .formatted(entitiCreateDto.getTierId())));

    entiti.setTier(tier);
    log.info("Successfully converted request to the new entiti");
    entiti = entitiRepo.save(entiti);
    log.info("Entiti successfully saved to the database with id: {}", entiti.getId());
    EntitiDto entitiDto = entitiMapper.entitiesToEntitiesDto(entiti);
    log.info("Successfully converted new entiti to the response");
    return entitiDto;
  }

  @Override
  public List<EntitiDto> getAll() {
    return entitiRepo.findAll().stream().map(entitiMapper::entitiesToEntitiesDto).toList();
  }

  @Override
  public EntitiDto getById(Integer id) {
    log.info("Entiti searching by id: {}, successfully started.", id);
    Entiti entiti = findById(id);
    log.info("Entiti searching by id: {}, completed successfully.", id);
    var response = entitiMapper.entitiesToEntitiesDto(entiti);
    log.info("Successfully converted entiti to response with id: {}", id);
    return response;
  }

  @Override
  public EntitiDto update(EntitiUpdateDto entitiUpdateDto) {
    Integer id = entitiUpdateDto.getId();
    log.info("Entiti update started for request with id: {}", id);
    Entiti entiti = findById(id);
    log.info("Entiti with id: {} exists and successfully retrieved from the database", id);
    Integer tierId = entitiUpdateDto.getTierId();
    if (Objects.nonNull(tierId)) {
      var tier =
          tierRepo
              .findById(tierId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an entiti with type not exist. Entiti id: %d, tierId: %d"
                              .formatted(id, tierId)));
      entiti.setTier(tier);
    }

    entitiMapper.updateEntities(entitiUpdateDto, entiti);
    log.info("Successfully updated entiti data with id: {} without saving", id);
    Entiti updatedEntiti = entitiRepo.save(entiti);
    log.info("Successfully save updated entiti into the database with id: {}", id);
    var response = entitiMapper.entitiesToEntitiesDto(updatedEntiti);
    log.info("Successfully converted updated entiti to the response");
    return response;
  }

  @Override
  public void deleteById(Integer id) {
    entitiRepo.delete(findById(id));
    log.info("Successfully converted entiti to response with id: {}", id);
  }

  private Entiti findById(Integer id) {
    return entitiRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Entiti doesn't found while searching by id: %d".formatted(id)));
  }
}
