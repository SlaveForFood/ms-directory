package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.FactionToBaseSkill;
import com.wff.ms.directory.repositories.FactionToBaseSkillRepo;

import com.wff.ms.directory.services.FactionToBaseSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactionToBaseSkillServiceImpl implements FactionToBaseSkillService {

    private final FactionToBaseSkillRepo factionToBaseSkillRepo;

    @Override
    public void create(FactionToBaseSkill factionToBaseSkill) {
        factionToBaseSkillRepo.save(factionToBaseSkill);
    }

    @Override
    public List<FactionToBaseSkill> getAll() {
        var skills = factionToBaseSkillRepo.findAll();
        return skills;
    }

    @Override
    public FactionToBaseSkill getById(Integer id) {
        var factionToBaseSkill =
                factionToBaseSkillRepo
                        .findById(id)
                        .orElseThrow(
                                () -> new NullPointerException(String.format("FactionToBaseSkill c id = %d не найден", id)));
        return factionToBaseSkill;
    }

    @Override
    public FactionToBaseSkill update(SkillUpdateDto skillUpdateDto) {
        FactionToBaseSkill factionToBaseSkill = new FactionToBaseSkill();
        factionToBaseSkillRepo.save(factionToBaseSkill);
        return factionToBaseSkill;
    }

    @Override
    public void delete(Integer id) {
        var factionToBaseSkill = getById(id);
        factionToBaseSkillRepo.delete(factionToBaseSkill);
    }
}
