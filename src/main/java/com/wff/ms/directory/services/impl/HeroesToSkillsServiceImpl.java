package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.entity.HeroToSkill;
import com.wff.ms.directory.repositories.HeroToSkillRepo;
import com.wff.ms.directory.services.HeroesToSkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroesToSkillsServiceImpl implements HeroesToSkillsService {
    private final HeroToSkillRepo heroToSkillRepo;
    @Override
    public void create(HeroToSkill heroToSkill) {
        heroToSkillRepo.save(heroToSkill);
    }

    @Override
    public List<HeroToSkill> getAll() {
        List<HeroToSkill> heroToSkillList = heroToSkillRepo.findAll();
        return heroToSkillList;
    }

    @Override
    public HeroToSkill getById(Integer id) {
        return heroToSkillRepo
                .findById(id)
                .orElseThrow(()->new NotFoundException(String.format(
                        "Продукт с id=%d не найден", id
                )));
    }

    @Override
    public String update(HeroToSkill heroToSkill) {
        getById(heroToSkill.getId());
        heroToSkillRepo.save(heroToSkill);
        return String.format("Продукт с id=%d успешно отредактирован", heroToSkill.getId());
    }

    @Override
    public boolean delete(Integer id) {
        var heroToSkill = getById(id);
        heroToSkillRepo.delete(heroToSkill);
        return true;
    }
}
