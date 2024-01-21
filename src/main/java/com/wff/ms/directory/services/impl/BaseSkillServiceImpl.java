package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.BaseSkill;

import com.wff.ms.directory.repositories.BaseSkillRepo;

import com.wff.ms.directory.services.BaseSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseSkillServiceImpl implements BaseSkillService {

    private final BaseSkillRepo baseSkillRepo;

    @Override
    public void create(BaseSkill baseSkill) {
        baseSkillRepo.save(baseSkill);
    }

    @Override
    public List<BaseSkill> getAll() {
        var baseSkills = baseSkillRepo.findAll();
        return baseSkills;
    }

    @Override
    public BaseSkill getById(Integer id) {
        var baseSkill =
                baseSkillRepo
                        .findById(id)
                        .orElseThrow(
                                () -> new NullPointerException(String.format("Skill c id = %d не найден", id)));
        return baseSkill;
    }

    @Override
    public BaseSkill update(SkillUpdateDto skillUpdateDto) {
        BaseSkill baseSkill = new BaseSkill();
        baseSkillRepo.save(baseSkill);
        return baseSkill;
    }

    @Override
    public void delete(Integer id) {
        var baseSkill = getById(id);
        baseSkillRepo.delete(baseSkill);
    }
}
