package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.TierCreateDto;
import com.wff.ms.directory.models.dto.response.TierDto;
import com.wff.ms.directory.models.dto.update.TierUpdateDto;
import com.wff.ms.directory.models.entity.Tier;
import com.wff.ms.directory.modules.mappers.TierMapper;
import com.wff.ms.directory.repositories.*;
import com.wff.ms.directory.services.TierService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TierServiceImpl implements TierService {

  private final TierRepo tierRepo;
  private final TierMapper tierMapper;

  @Override
  public TierDto create(TierCreateDto tierCreateDto) {
    log.info("Tier creation started");
    Tier tier = tierMapper.tierCreateDtoToTier(tierCreateDto);
    log.info("Successfully converted request to the new tier");
    tier = tierRepo.save(tier);
    log.info("Tier successfully saved to the database with id: {}", tier.getId());
    TierDto tierDto = tierMapper.tierToTierDto(tier);
    log.info("Successfully converted new tier to the response");
    return tierDto;
  }

  @Override
  public List<TierDto> getAll() {
    return tierRepo.findAll().stream().map(tierMapper::tierToTierDto).toList();
  }

  @Override
  public TierDto getById(Integer id) {
    log.info("tier searching by id: {}, successfully started.", id);
    Tier tier = findById(id);
    log.info("Tier searching by id: {}, completed successfully.", id);
    var response = tierMapper.tierToTierDto(tier);
    log.info("Successfully converted tier to response with id: {}", id);
    return response;
  }

  @Override
  public TierDto update(TierUpdateDto tierUpdateDto) {
    Integer id = tierUpdateDto.getId();
    log.info("Tier update started for request with id: {}", id);
    Tier tier = findById(id);
    log.info("Tier with id: {} exists and successfully retrieved from the database", id);
    tierMapper.updateTier(tierUpdateDto, tier);
    log.info("Successfully updated tier data with id: {} without saving", id);
    Tier updatedTier = tierRepo.save(tier);
    log.info("Successfully save updated tier into the database with id: {}", id);
    var response = tierMapper.tierToTierDto(updatedTier);
    log.info("Successfully converted updated tier to the response");
    return response;
  }

  @Override
  public void deleteById(Integer id) {
    tierRepo.delete(findById(id));
    log.info("Successfully converted tier to response with id: {}", id);
  }

  private Tier findById(Integer id) {
    return tierRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Tier doesn't found while searching by id: %d".formatted(id)));
  }
}
