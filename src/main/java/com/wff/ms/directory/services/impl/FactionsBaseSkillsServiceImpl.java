package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.FactionsBaseSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.FactionsBaseSkillsDto;
import com.wff.ms.directory.models.dto.update.FactionsBaseSkillsUpdateDto;
import com.wff.ms.directory.models.entity.FactionsBaseSkills;
import com.wff.ms.directory.modules.mappers.FactionsBaseSkillsMapper;
import com.wff.ms.directory.repositories.FactionsBaseSkillsRepo;
import com.wff.ms.directory.services.FactionsBaseSkillsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactionsBaseSkillsServiceImpl implements FactionsBaseSkillsService {

  private final FactionsBaseSkillsRepo factionsBaseSkillsRepo;
  private final FactionsBaseSkillsMapper factionsBaseSkillsMapper;

  @Override
  public FactionsBaseSkillsDto create(FactionsBaseSkillsCreateDto factionsBaseSkillsCreateDto) {
    FactionsBaseSkills factionsBaseSkills =
        factionsBaseSkillsMapper.factionsBaseSkillsCreateDtoToFactionsBaseSkill(
            factionsBaseSkillsCreateDto);
    factionsBaseSkills = factionsBaseSkillsRepo.save(factionsBaseSkills);
    return factionsBaseSkillsMapper.factionBaseSkillsToFactionBaseSkillsDto(factionsBaseSkills);
  }

  @Override
  public FactionsBaseSkillsDto update(FactionsBaseSkillsUpdateDto factionsBaseSkillsUpdateDto) {
    FactionsBaseSkills factionsBaseSkills = findById(factionsBaseSkillsUpdateDto.getId());
    factionsBaseSkillsMapper.updateFactionBaseSkills(
        factionsBaseSkillsUpdateDto, factionsBaseSkills);
    factionsBaseSkillsRepo.save(factionsBaseSkills);
    return factionsBaseSkillsMapper.factionBaseSkillsToFactionBaseSkillsDto(factionsBaseSkills);
  }

  @Override
  public List<FactionsBaseSkillsDto> getAll() {
    return factionsBaseSkillsRepo.findAll().stream()
        .map(factionsBaseSkillsMapper::factionBaseSkillsToFactionBaseSkillsDto)
        .toList();
  }

  @Override
  public FactionsBaseSkillsDto getById(Integer id) {
    return factionsBaseSkillsMapper.factionBaseSkillsToFactionBaseSkillsDto(findById(id));
  }

  @Override
  public void deleteById(Integer id) {
    factionsBaseSkillsRepo.delete(findById(id));
  }

  private FactionsBaseSkills findById(Integer id) {
    return factionsBaseSkillsRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "FactionsBaseSkills doesn't found while searching by id: %d".formatted(id)));
  }
}
