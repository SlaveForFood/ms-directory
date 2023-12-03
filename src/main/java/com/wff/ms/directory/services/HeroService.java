package com.wff.ms.directory.services;
import com.wff.ms.directory.models.entity.Hero;
import java.util.List;

public interface HeroService {
    void create(Hero hero);
    List<Hero> getAll();
    Hero get(Integer id);
    Hero update();
    boolean delete(Integer id);
}
