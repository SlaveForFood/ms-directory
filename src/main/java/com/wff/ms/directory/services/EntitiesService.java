package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.EntitiesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesDto;
import com.wff.ms.directory.models.dto.update.EntitiesUpdateDto;
import java.util.List;

public interface EntitiesService {

  EntitiesDto create(EntitiesCreateDto entitiesCreateDto);

  List<EntitiesDto> getAll();

  EntitiesDto getById(Integer id);

  EntitiesDto update(EntitiesUpdateDto entitiesUpdateDto);

  void deleteById(Integer id);
}
