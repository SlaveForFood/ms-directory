package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.create.EntitiesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesSkillsDto;
import com.wff.ms.directory.models.dto.update.EntitiesSkillsUpdateDto;
import java.util.List;

public interface EntitiesSkillsService {

  EntitiesSkillsDto create(EntitiesSkillsCreateDto entitiesSkillsCreateDto);

  List<EntitiesSkillsDto> getAll();

  EntitiesSkillsDto getById(Integer id);

  EntitiesSkillsDto update(EntitiesSkillsUpdateDto entitiesSkillsUpdateDto);

  void deleteById(Integer id);
}
