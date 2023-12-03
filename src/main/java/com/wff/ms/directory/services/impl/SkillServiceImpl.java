package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.Skill;
import com.wff.ms.directory.repositories.SkillRepo;
import com.wff.ms.directory.services.SkillService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

  private final SkillRepo skillRepo;

  @Override
  public void create(Skill skill) {
    skillRepo.save(skill);
  }

  @Override
  public List<Skill> getAll() {
    var skills = skillRepo.findAll();
    return skills;
  }

  @Override
  public Skill getById(Integer id) {
    var skill =
        skillRepo
            .findById(id)
            .orElseThrow(
                () -> new NullPointerException(String.format("Skill c id = %d не найден", id)));
    return skill;
  }

  @Override
  public Skill update(SkillUpdateDto skillUpdateDto) {
    Skill skill = new Skill();
    skillRepo.save(skill);
    return skill;
  }

  @Override
  public void delete(Integer id) {
    var skill = getById(id);
    skillRepo.delete(skill);
  }
}
