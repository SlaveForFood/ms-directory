package com.wff.ms.directory.services;

import com.wff.ms.directory.models.dto.update.FactionUpdateDto;
import com.wff.ms.directory.models.entity.Faction;

import java.util.List;

public interface FactionService {
  void create(Faction faction);

  List<Faction> getAll();

  Faction getById(Integer id);

  String update(FactionUpdateDto factionUpdateDto);

  void delete(Integer id);
}
