package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.HeroDto;
import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.entity.Hero;

import java.util.List;

public interface HeroService {
    HeroDto create(HeroCreateDto heroCreateDto);

    List<Hero> getAll();

    Hero getById(Integer id);

    String update(Hero hero);

    boolean delete(Integer id);
}
