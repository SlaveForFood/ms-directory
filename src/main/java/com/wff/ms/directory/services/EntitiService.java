package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.EntitiCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiDto;
import com.wff.ms.directory.models.dto.update.EntitiUpdateDto;
import java.util.List;

public interface EntitiService {

  EntitiDto create(EntitiCreateDto entitiCreateDto);

  List<EntitiDto> getAll();

  EntitiDto getById(Integer id);

  EntitiDto update(EntitiUpdateDto entitiUpdateDto);

  void deleteById(Integer id);
}
