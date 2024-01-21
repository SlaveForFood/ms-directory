package com.wff.ms.directory.services;


import com.wff.ms.directory.models.entity.Faction;


import java.util.List;

public interface FactionService {
    void create(Faction faction);

    List<Faction> getAll();

    Faction getById(Integer id);

//    Faction update(SkillUpdateDto skillUpdateDto);

    void delete(Integer id);
}
