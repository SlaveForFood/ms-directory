package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.update.FactionUpdateDto;
import com.wff.ms.directory.models.entity.Faction;
import com.wff.ms.directory.repositories.FactionRepo;
import com.wff.ms.directory.services.FactionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
  public String update(FactionUpdateDto factionUpdateDto) {
    Faction faction = new Faction();
    factionRepo.save(faction);
    return "faction updated";
  }

  @Override
  public void delete(Integer id) {
    var faction = getById(id);
    factionRepo.delete(faction);
  }
}
