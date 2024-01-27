package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.TierCreateDto;
import com.wff.ms.directory.models.dto.response.TierDto;
import com.wff.ms.directory.models.dto.update.TierUpdateDto;
import java.util.List;

public interface TierService {

  TierDto create(TierCreateDto tierCreateDto);

  List<TierDto> getAll();

  TierDto getById(Integer id);

  TierDto update(TierUpdateDto tierUpdateDto);

  void deleteById(Integer id);
}
