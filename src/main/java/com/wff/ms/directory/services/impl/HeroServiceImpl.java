package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService  {
    private final HeroRepo heroRepo;

    @Override
    public void create(Hero hero){

    }

    @Override
    public List<Hero> getAll() {
        return null;
    }

    @Override
    public Hero get(Integer id) {
        return null;
    }

    @Override
    public Hero update() {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
