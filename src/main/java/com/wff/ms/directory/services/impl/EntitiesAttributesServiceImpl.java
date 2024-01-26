package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.EntitiesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesAttributesDto;
import com.wff.ms.directory.models.dto.update.EntitiesAttributesUpdateDto;
import com.wff.ms.directory.models.entity.EntitiesAttributes;
import com.wff.ms.directory.modules.mappers.EntitiesAttributesMapper;
import com.wff.ms.directory.repositories.AttributesRepo;
import com.wff.ms.directory.repositories.EntitiesAttributesRepo;
import com.wff.ms.directory.repositories.EntitiesRepo;
import com.wff.ms.directory.services.EntitiesAttributesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class EntitiesAttributesServiceImpl implements EntitiesAttributesService {

    private final EntitiesAttributesRepo entitiesAttributesRepo;
    private final EntitiesRepo entitiesRepo;
    private final AttributesRepo attributesRepo;
    private final EntitiesAttributesMapper entitiesAttributesMapper;

    @Override
    public EntitiesAttributesDto create(EntitiesAttributesCreateDto entitiesAttributesCreateDto) {
        log.info("EntitiesAttributes creation started");
        EntitiesAttributes entitiesAttributes = entitiesAttributesMapper.entitiesAttributesCreateDtoToEntitiesAttributes(entitiesAttributesCreateDto);
        var entities =
                entitiesRepo
                        .findById(entitiesAttributesCreateDto.getEntitiesId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an EntitiesAttributes with type not exist. typeId: %d"
                                                        .formatted(entitiesAttributesCreateDto.getEntitiesId())));
        var attribute =
                attributesRepo
                        .findById(entitiesAttributesCreateDto.getAttributeId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an EntitiesAttributes with class not exist. clazzId: %d"
                                                        .formatted(entitiesAttributesCreateDto.getAttributeId())));
        entitiesAttributes.setEntity(entities);
        entitiesAttributes.setAttribute(attribute);
        log.info("Successfully converted request to the new entitiesAttributes");
        entitiesAttributes = entitiesAttributesRepo.save(entitiesAttributes);
        log.info("entitiesAttributes successfully saved to the database with id: {}", entitiesAttributes.getId());
        EntitiesAttributesDto entitiesAttributesDto = entitiesAttributesMapper.entitiesAttributesToEntitiesAttributesDto(entitiesAttributes);
        log.info("Successfully converted new entitiesAttributes to the response");
        return entitiesAttributesDto;
    }

    @Override
    public List<EntitiesAttributesDto> getAll() {
        return entitiesAttributesRepo.findAll().stream().map(entitiesAttributesMapper::entitiesAttributesToEntitiesAttributesDto).toList();
    }

    @Override
    public EntitiesAttributesDto getById(Integer id) {
        log.info("entitiesAttributes searching by id: {}, successfully started.", id);
        EntitiesAttributes entitiesAttributes = findById(id);
        log.info("entitiesAttributes searching by id: {}, completed successfully.", id);
        var response = entitiesAttributesMapper.entitiesAttributesToEntitiesAttributesDto(entitiesAttributes);
        log.info("Successfully converted artifact to response with id: {}", id);
        return response;
    }

    @Override
    public EntitiesAttributesDto update(EntitiesAttributesUpdateDto entitiesAttributesUpdateDto) {
        Integer id = entitiesAttributesUpdateDto.getId();
        log.info("entitiesAttributes update started for request with id: {}", id);
        EntitiesAttributes entitiesAttributes = findById(id);
        log.info("entitiesAttributes with id: {} exists and successfully retrieved from the database", id);
        Integer entitiesId = entitiesAttributesUpdateDto.getEntitiesId();
        if (Objects.nonNull(entitiesId)) {
            var entities =
                    entitiesRepo
                            .findById(entitiesId)
                            .orElseThrow(
                                    () ->
                                            new NotFoundException(
                                                    "Trying to update an entitiesAttributes with type not exist. entitiesAttributes id: %d, entitiesId: %d"
                                                            .formatted(id, entitiesId)));
            entitiesAttributes.setEntity(entities);
        }
        Integer attributeId = entitiesAttributesUpdateDto.getAttributeId();
        if (Objects.nonNull(attributeId)) {
            var attribute =
                    attributesRepo
                            .findById(attributeId)
                            .orElseThrow(
                                    () ->
                                            new NotFoundException(
                                                    "Trying to update an entitiesAttributes with class not exist. entitiesAttributes id: %d, attributeId: %d"
                                                            .formatted(id, attributeId)));
            entitiesAttributes.setAttribute(attribute);
        }
        entitiesAttributesMapper.updateEntitiesAttributes(entitiesAttributesUpdateDto, entitiesAttributes);
        log.info("Successfully updated entitiesAttributes data with id: {} without saving", id);
        EntitiesAttributes updatedEntitiesAttributes = entitiesAttributesRepo.save(entitiesAttributes);
        log.info("Successfully save updated entitiesAttributes into the database with id: {}", id);
        var response = entitiesAttributesMapper.entitiesAttributesToEntitiesAttributesDto(updatedEntitiesAttributes);
        log.info("Successfully converted updated entitiesAttributes to the response");
        return response;
    }

    @Override
    public void deleteById(Integer id) {
        entitiesAttributesRepo.delete(findById(id));
        log.info("Successfully converted entitiesAttributes to response with id: {}", id);
    }

    private EntitiesAttributes findById(Integer id) {
        return entitiesAttributesRepo
                .findById(id)
                .orElseThrow(
                        () ->
                                new NotFoundException(
                                        "entitiesAttributes doesn't found while searching by id: %d".formatted(id)));
    }
}
