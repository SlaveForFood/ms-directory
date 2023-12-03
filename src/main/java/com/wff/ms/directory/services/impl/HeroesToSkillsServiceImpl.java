package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.entity.HeroesToSkills;
import com.wff.ms.directory.services.HeroesToSkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroesToSkillsServiceImpl implements HeroesToSkillsService {

    @Override
    public void create(HeroesToSkills hero) {

    }

    @Override
    public List<HeroesToSkills> getAll() {
        return null;
    }

    @Override
    public HeroesToSkills get(Integer id) {
        return null;
    }

    @Override
    public HeroesToSkills update() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
