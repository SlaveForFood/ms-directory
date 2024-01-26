package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.EntitiesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesDto;
import com.wff.ms.directory.models.dto.update.EntitiesUpdateDto;
import com.wff.ms.directory.models.entity.Entities;
import com.wff.ms.directory.modules.mappers.EntitiesMapper;
import com.wff.ms.directory.repositories.*;
import java.util.List;
import java.util.Objects;

import com.wff.ms.directory.services.EntitiesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class EntitiesServiceImpl implements EntitiesService {

    private final EntitiesRepo entitiesRepo;
    private final TierRepo tierRepo;
    private final EntitiesMapper entitiesMapper;

    @Override
    public EntitiesDto create(EntitiesCreateDto entitiesCreateDto) {
        log.info("Entiti creation started");
        Entities entities = entitiesMapper.entitiesCreateDtoToEntities(entitiesCreateDto);
        var tier =
                tierRepo
                        .findById(entitiesCreateDto.getTierId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an entiti with tier not exist. typeId: %d"
                                                        .formatted(entitiesCreateDto.getTierId())));

        entities.setTier(tier);
        log.info("Successfully converted request to the new entiti");
        entities = entitiesRepo.save(entities);
        log.info("Entiti successfully saved to the database with id: {}", entities.getId());
        EntitiesDto entitiesDto = entitiesMapper.entitiesToEntitiesDto(entities);
        log.info("Successfully converted new entiti to the response");
        return entitiesDto;
    }

    @Override
    public List<EntitiesDto> getAll() {
        return entitiesRepo.findAll().stream().map(entitiesMapper::entitiesToEntitiesDto).toList();
    }

    @Override
    public EntitiesDto getById(Integer id) {
        log.info("Entiti searching by id: {}, successfully started.", id);
        Entities entities = findById(id);
        log.info("Entiti searching by id: {}, completed successfully.", id);
        var response = entitiesMapper.entitiesToEntitiesDto(entities);
        log.info("Successfully converted entiti to response with id: {}", id);
        return response;
    }

    @Override
    public EntitiesDto update(EntitiesUpdateDto entitiesUpdateDto) {
        Integer id = entitiesUpdateDto.getId();
        log.info("Entiti update started for request with id: {}", id);
        Entities entities = findById(id);
        log.info("Entiti with id: {} exists and successfully retrieved from the database", id);
        Integer tierId = entitiesUpdateDto.getTierId();
        if (Objects.nonNull(tierId)) {
            var tier =
                    tierRepo
                            .findById(tierId)
                            .orElseThrow(
                                    () ->
                                            new NotFoundException(
                                                    "Trying to update an entiti with type not exist. Entiti id: %d, tierId: %d"
                                                            .formatted(id, tierId)));
            entities.setTier(tier);
        }

        entitiesMapper.updateEntities(entitiesUpdateDto, entities);
        log.info("Successfully updated entiti data with id: {} without saving", id);
        Entities updatedEntities = entitiesRepo.save(entities);
        log.info("Successfully save updated entiti into the database with id: {}", id);
        var response = entitiesMapper.entitiesToEntitiesDto(updatedEntities);
        log.info("Successfully converted updated entiti to the response");
        return response;
    }

    @Override
    public void deleteById(Integer id) {
        entitiesRepo.delete(findById(id));
        log.info("Successfully converted entiti to response with id: {}", id);
    }

    private Entities findById(Integer id) {
        return entitiesRepo
                .findById(id)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        "Entiti doesn't found while searching by id: %d".formatted(id)));
    }
}
