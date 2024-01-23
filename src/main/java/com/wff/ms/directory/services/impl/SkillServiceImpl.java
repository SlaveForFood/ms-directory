package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.SkillCreateDto;
import com.wff.ms.directory.models.dto.response.SkillDto;
import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.Skill;
import com.wff.ms.directory.modules.mappers.SkillMapper;
import com.wff.ms.directory.repositories.SkillRepo;
import com.wff.ms.directory.services.SkillService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

  private final SkillRepo skillRepo;
  private final SkillMapper skillMapper;

  @Override
  public SkillDto create(SkillCreateDto skillCreateDto) {
    Skill skill = skillMapper.skillCreateDtoToSkill(skillCreateDto);
    skill = skillRepo.save(skill);
    return skillMapper.skillToSkillDto(skill);
  }

  @Override
  public List<SkillDto> getAll() {
    return skillRepo.findAll().stream().map(skillMapper::skillToSkillDto).toList();
  }

  @Override
  public SkillDto getById(Integer id) {
    Skill skill = findById(id);
    return skillMapper.skillToSkillDto(skill);
  }

  @Override
  public SkillDto update(SkillUpdateDto skillUpdateDto) {
    Integer id = skillUpdateDto.getId();
    Skill skill = findById(id);
    skillMapper.updateSkill(skillUpdateDto, skill);
    Skill updatedSkill = skillRepo.save(skill);
    return skillMapper.skillToSkillDto(updatedSkill);
  }

  @Override
  public void deleteById(Integer id) {
    skillRepo.delete(findById(id));
  }

  private Skill findById(Integer id) {
    return skillRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Skill doesn't found while searching by id: %d".formatted(id)));
  }
}
