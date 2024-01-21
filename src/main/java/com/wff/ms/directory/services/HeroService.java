package com.wff.ms.directory.services;
import com.wff.ms.directory.models.entity.Hero;
import java.util.List;

public interface HeroService {
    Integer create(Hero hero);
    List<Hero> getAll();
    Hero getById(Integer id);
    String update(Hero hero);
    boolean delete(Integer id);
}
