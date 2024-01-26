package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.FactionCreateDto;
import com.wff.ms.directory.models.dto.response.FactionDto;
import com.wff.ms.directory.models.dto.update.FactionUpdateDto;
import java.util.List;

public interface FactionService {
  FactionDto create(FactionCreateDto factionCreateDto);

  List<FactionDto> getAll();

  FactionDto getById(Integer id);

  FactionDto update(FactionUpdateDto factionUpdateDto);

  void deleteById(Integer id);
}
