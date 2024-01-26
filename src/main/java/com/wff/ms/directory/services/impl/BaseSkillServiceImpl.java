package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.BaseSkillCreateDto;
import com.wff.ms.directory.models.dto.response.BaseSkillsDto;
import com.wff.ms.directory.models.dto.update.BaseSkillUpdateDto;
import com.wff.ms.directory.models.entity.BaseSkill;
import com.wff.ms.directory.modules.mappers.BaseSkillMapper;
import com.wff.ms.directory.repositories.BaseSkillRepo;
import com.wff.ms.directory.services.BaseSkillService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseSkillServiceImpl implements BaseSkillService {

  private final BaseSkillRepo baseSkillRepo;
  private final BaseSkillMapper baseSkillMapper;

  @Override
  public BaseSkillsDto create(BaseSkillCreateDto baseSkillCreateDto) {
    var baseSkill = baseSkillMapper.baseSkillCreateDtoToBaseSkill(baseSkillCreateDto);
    baseSkill = baseSkillRepo.save(baseSkill);
    return baseSkillMapper.baseSkillToBaseSkillDto(baseSkill);
  }

  @Override
  public BaseSkillsDto update(BaseSkillUpdateDto baseSkillUpdateDto) {
    BaseSkill baseSkill = findById(baseSkillUpdateDto.getId());
    baseSkillMapper.updateBaseSkill(baseSkillUpdateDto, baseSkill);
    baseSkillRepo.save(baseSkill);
    return baseSkillMapper.baseSkillToBaseSkillDto(baseSkill);
  }

  @Override
  public List<BaseSkillsDto> getAll() {
    return baseSkillRepo.findAll().stream().map(baseSkillMapper::baseSkillToBaseSkillDto).toList();
  }

  @Override
  public BaseSkillsDto getById(Integer id) {
    return baseSkillMapper.baseSkillToBaseSkillDto(findById(id));
  }

  @Override
  public void deleteById(Integer id) {
    baseSkillRepo.delete(findById(id));
  }

  private BaseSkill findById(Integer id) {
    return baseSkillRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "BaseSkill doesn't found while searching by id: %d".formatted(id)));
  }
}
