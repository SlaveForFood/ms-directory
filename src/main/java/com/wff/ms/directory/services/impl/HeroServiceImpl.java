package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService  {
    private final HeroRepo heroRepo;

    @Override
    public Integer create(Hero hero){
        heroRepo.save(hero);return hero.getId();
    }

    @Override
    public List<Hero> getAll() {
        List<Hero> heroes = heroRepo.findAll();
        return heroes;
    }

    @Override
    public Hero getById(Integer id) {
        return heroRepo
                .findById(id)
                .orElseThrow(()->new NotFoundException(String.format(
                        "Продукт с id=%d не найден", id
                )));
    }

    @Override
    public String update(Hero hero) {
        getById(hero.getId());
        heroRepo.save(hero);
        return String.format("Продукт с id=%d успешно отредактирован",hero.getId());
    }

    @Override
    public boolean delete(Integer id) {
        var hero = getById(id);
        heroRepo.delete(hero);
        return true;
    }
}
