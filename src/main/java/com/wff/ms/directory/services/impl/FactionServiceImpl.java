package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.models.entity.Faction;
import com.wff.ms.directory.repositories.FactionRepo;
import com.wff.ms.directory.services.FactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactionServiceImpl implements FactionService {

    private final FactionRepo factionRepo;

    @Override
    public void create(Faction faction) {
        factionRepo.save(faction);
    }

    @Override
    public List<Faction> getAll() {
        var factions = factionRepo.findAll();
        return factions;
    }

    @Override
    public Faction getById(Integer id) {
        var faction =
                factionRepo
                        .findById(id)
                        .orElseThrow(
                                () -> new NullPointerException(String.format("Faction c id = %d не найден", id)));
        return faction;
    }

    @Override
    public Faction update(SkillUpdateDto skillUpdateDto) {
        Faction faction = new Faction();
        factionRepo.save(faction);
        return faction;
    }

    @Override
    public void delete(Integer id) {
        var faction = getById(id);
        factionRepo.delete(faction);
    }
}
