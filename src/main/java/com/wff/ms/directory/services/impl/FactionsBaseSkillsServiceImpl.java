package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.update.FactionsBaseSkillsUpdateDto;
import com.wff.ms.directory.models.entity.FactionsBaseSkills;
import com.wff.ms.directory.repositories.FactionsBaseSkillsRepo;
import com.wff.ms.directory.services.FactionsBaseSkillsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactionsBaseSkillsServiceImpl implements FactionsBaseSkillsService {

  private final FactionsBaseSkillsRepo factionsBaseSkillsRepo;

  @Override
  public void create(FactionsBaseSkills factionsBaseSkills) {
    factionsBaseSkillsRepo.save(factionsBaseSkills);
  }

  @Override
  public List<FactionsBaseSkills> getAll() {
    var skills = factionsBaseSkillsRepo.findAll();
    return skills;
  }

  @Override
  public FactionsBaseSkills getById(Integer id) {
    var factionsBaseSkills =
        factionsBaseSkillsRepo
            .findById(id)
            .orElseThrow(
                () ->
                    new NullPointerException(
                        String.format("FactionsBaseSkills c id = %d не найден", id)));
    return factionsBaseSkills;
  }

  @Override
  public String update(FactionsBaseSkillsUpdateDto factionsBaseSkillsUpdateDto) {
    FactionsBaseSkills factionsBaseSkills = new FactionsBaseSkills();
    factionsBaseSkillsRepo.save(factionsBaseSkills);
    return "factionsBaseSkills updated";
  }

  @Override
  public void delete(Integer id) {
    var factionsBaseSkills = getById(id);
    factionsBaseSkillsRepo.delete(factionsBaseSkills);
  }
}
