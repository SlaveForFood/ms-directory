package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.AttributeCreateDto;
import com.wff.ms.directory.models.dto.response.AttributeDto;
import com.wff.ms.directory.models.dto.update.AttributesUpdateDto;
import com.wff.ms.directory.models.entity.Attribute;
import com.wff.ms.directory.modules.mappers.AttributeMapper;
import com.wff.ms.directory.repositories.*;
import com.wff.ms.directory.services.AttributeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

  private final AttributeRepo attributesRepo;
  private final AttributeMapper attributeMapper;

  @Override
  public AttributeDto create(AttributeCreateDto attributeCreateDto) {
    log.info("Attribute creation started");
    Attribute attribute = attributeMapper.attributeCreateDtoToAttribute(attributeCreateDto);
    log.info("Successfully converted request to the new attribute");
    attribute = attributesRepo.save(attribute);
    log.info("Attribute successfully saved to the database with id: {}", attribute.getId());
    AttributeDto attributeDto = attributeMapper.attributeToAttributeDto(attribute);
    log.info("Successfully converted new attribute to the response");
    return attributeDto;
  }

  @Override
  public List<AttributeDto> getAll() {
    return attributesRepo.findAll().stream().map(attributeMapper::attributeToAttributeDto).toList();
  }

  @Override
  public AttributeDto getById(Integer id) {
    log.info("attribute searching by id: {}, successfully started.", id);
    Attribute attribute = findById(id);
    log.info("attribute searching by id: {}, completed successfully.", id);
    var response = attributeMapper.attributeToAttributeDto(attribute);
    log.info("Successfully converted attribute to response with id: {}", id);
    return response;
  }

  @Override
  public AttributeDto update(AttributesUpdateDto attributesUpdateDto) {
    Integer id = attributesUpdateDto.getId();
    log.info("Attribute update started for request with id: {}", id);
    Attribute attribute = findById(id);
    log.info("Attribute with id: {} exists and successfully retrieved from the database", id);
    attributeMapper.updateAttribute(attributesUpdateDto, attribute);
    log.info("Successfully updated tier data with id: {} without saving", id);
    Attribute updatedAttribute = attributesRepo.save(attribute);
    log.info("Successfully save updated attribute into the database with id: {}", id);
    var response = attributeMapper.attributeToAttributeDto(updatedAttribute);
    log.info("Successfully converted updated attribute to the response");
    return response;
  }

  @Override
  public void deleteById(Integer id) {
    attributesRepo.delete(findById(id));
    log.info("Successfully converted attribute to response with id: {}", id);
  }

  private Attribute findById(Integer id) {
    return attributesRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Tier doesn't found while searching by id: %d".formatted(id)));
  }
}
