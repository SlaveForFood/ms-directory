package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.response.HeroDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import java.util.List;

public interface HeroService {
  HeroDto create(HeroCreateDto heroCreateDto);

  List<HeroDto> getAll();

  HeroDto getById(Integer id);

  HeroDto update(HeroUpdateDto dto);

  void deleteById(Integer id);
}
