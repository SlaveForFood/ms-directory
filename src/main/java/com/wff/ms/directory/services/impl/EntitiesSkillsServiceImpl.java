package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.EntitiesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesSkillsDto;
import com.wff.ms.directory.models.dto.update.EntitiesSkillsUpdateDto;
import com.wff.ms.directory.models.entity.EntitiesSkills;
import com.wff.ms.directory.modules.mappers.EntitiesSkillsMapper;
import com.wff.ms.directory.repositories.EntitiesRepo;
import com.wff.ms.directory.repositories.EntitiesSkillsRepo;
import com.wff.ms.directory.repositories.SkillRepo;
import com.wff.ms.directory.services.EntitiesSkillsService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntitiesSkillsServiceImpl implements EntitiesSkillsService {

  private final EntitiesSkillsRepo entitiesSkillsRepo;
  private final EntitiesRepo entitiesRepo;
  private final SkillRepo skillRepo;
  private final EntitiesSkillsMapper entitiesSkillsMapper;

  @Override
  public EntitiesSkillsDto create(EntitiesSkillsCreateDto entitiesSkillsCreateDto) {

    EntitiesSkills entitiesSkills =
        entitiesSkillsMapper.entitiesSkillsCreateDtoToEntitiesSkills(entitiesSkillsCreateDto);

    var entiti =
        entitiesRepo
            .findById(entitiesSkillsCreateDto.getEntitiId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an entitiesSkills with entity not exist. typeId: %d"
                            .formatted(entitiesSkillsCreateDto.getEntitiId())));

    var skill =
        skillRepo
            .findById(entitiesSkillsCreateDto.getSkillId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an entitiesSkills with skill not exist. clazzId: %d"
                            .formatted(entitiesSkillsCreateDto.getSkillId())));

    entitiesSkills.setEntity(entiti);
    entitiesSkills.setSkill(skill);

    entitiesSkills = entitiesSkillsRepo.save(entitiesSkills);

    return entitiesSkillsMapper.entitiesSkillsToEntitiesSkillsDto(entitiesSkills);
  }

  @Override
  public List<EntitiesSkillsDto> getAll() {
    return entitiesSkillsRepo.findAll().stream()
        .map(entitiesSkillsMapper::entitiesSkillsToEntitiesSkillsDto)
        .toList();
  }

  @Override
  public EntitiesSkillsDto getById(Integer id) {
    EntitiesSkills entitiesSkills = findById(id);
    return entitiesSkillsMapper.entitiesSkillsToEntitiesSkillsDto(entitiesSkills);
  }

  @Override
  public EntitiesSkillsDto update(EntitiesSkillsUpdateDto entitiesSkillsUpdateDto) {
    Integer id = entitiesSkillsUpdateDto.getId();
    EntitiesSkills entitiesSkills = findById(id);
    Integer entitiId = entitiesSkillsUpdateDto.getEntitiId();

    if (Objects.nonNull(entitiId)) {
      var entiti =
          entitiesRepo
              .findById(entitiId)
              .orElseThrow(
                  () ->
                      new com.wff.ms.directory.exceptions.NotFoundException(
                          "Trying to update an entitiesSkills with entity not exist. EntitiesSkills id: %d, entityId: %d"
                              .formatted(id, entitiId)));
      entitiesSkills.setEntity(entiti);
    }

    Integer skillId = entitiesSkillsUpdateDto.getSkillId();
    if (Objects.nonNull(skillId)) {
      var skill =
          skillRepo
              .findById(skillId)
              .orElseThrow(
                  () ->
                      new com.wff.ms.directory.exceptions.NotFoundException(
                          "Trying to update an entitiesSkills with skill not exist. EntitiesSkills id: %d, skillId: %d"
                              .formatted(id, skillId)));
      entitiesSkills.setSkill(skill);
    }

    entitiesSkillsMapper.updateEntitiesSkills(entitiesSkillsUpdateDto, entitiesSkills);
    EntitiesSkills updatedEntitiesSkills = entitiesSkillsRepo.save(entitiesSkills);
    return entitiesSkillsMapper.entitiesSkillsToEntitiesSkillsDto(updatedEntitiesSkills);
  }

  @Override
  public void deleteById(Integer id) {
    entitiesSkillsRepo.delete(findById(id));
  }

  private EntitiesSkills findById(Integer id) {
    return entitiesSkillsRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "EntitiesSkills doesn't found while searching by id: %d".formatted(id)));
  }
}
