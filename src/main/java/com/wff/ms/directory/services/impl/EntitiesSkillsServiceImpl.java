package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.entity.EntitiesSkills;
import com.wff.ms.directory.repositories.EntitiesSkillsRepo;
import com.wff.ms.directory.services.EntitiesSkillsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntitiesSkillsServiceImpl implements EntitiesSkillsService {
  private final EntitiesSkillsRepo entitiesSkillsRepo;

  @Override
  public void create(EntitiesSkills entitiesSkills) {
    entitiesSkillsRepo.save(entitiesSkills);
  }

  @Override
  public List<EntitiesSkills> getAll() {
    return entitiesSkillsRepo.findAll();
  }

  @Override
  public EntitiesSkills getById(Integer id) {
    var entitiesSkills =
        entitiesSkillsRepo
            .findById(id)
            .orElseThrow(
                () ->
                    new NullPointerException(
                        String.format("Entities Skills with id = %d not found", id)));
    return entitiesSkills;
  }

  @Override
  public EntitiesSkills update() {
    EntitiesSkills entitiesSkills = new EntitiesSkills();
    entitiesSkillsRepo.save(entitiesSkills);
    return entitiesSkills;
  }

  @Override
  public void deleteById(Integer id) {
    var entitiesSkills = getById(id);
    entitiesSkillsRepo.delete(entitiesSkills);
  }
}