package com.wff.ms.directory.modules.mappers;

import com.wff.ms.directory.models.dto.HeroDto;
import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import org.springframework.stereotype.Component;

import com.wff.ms.directory.models.entity.Hero;

@Component
public class HeroMapper {

    public Hero mapToModel(HeroCreateDto dto){
        Hero hero = new Hero();
        //hero.setId(dto.getHeroID()); // подправить
        hero.setName(dto.getName());
        hero.setDescription(dto.getDescription());
        return hero;
        // Не работает так: .setID(..).setName(..).setD...n(..)
    }

    public HeroDto mapToEntity(Hero hero){
        HeroDto dto = new HeroDto();
        dto.setId(hero.getId());
        dto.setName(hero.getName());
        dto.setDescription(hero.getDescription());
        // Faction еще
        return dto;
    }

}
