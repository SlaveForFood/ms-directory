package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.AttributeCreateDto;
import com.wff.ms.directory.models.dto.response.AttributeDto;
import com.wff.ms.directory.models.dto.update.AttributesUpdateDto;
import java.util.List;

public interface AttributeService {
  AttributeDto create(AttributeCreateDto attributeCreateDto);

  List<AttributeDto> getAll();

  AttributeDto getById(Integer id);

  AttributeDto update(AttributesUpdateDto attributesUpdateDto);

  void deleteById(Integer id);
}
