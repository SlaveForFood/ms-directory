package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.EntitiesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesAttributesDto;
import com.wff.ms.directory.models.dto.update.EntitiesAttributesUpdateDto;
import java.util.List;

public interface EntitiesAttributesService {

  EntitiesAttributesDto create(EntitiesAttributesCreateDto entitiesAttributesCreateDto);

  List<EntitiesAttributesDto> getAll();

  EntitiesAttributesDto getById(Integer id);

  EntitiesAttributesDto update(EntitiesAttributesUpdateDto entitiesAttributesUpdateDto);

  void deleteById(Integer id);
}
