package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.FactionCreateDto;
import com.wff.ms.directory.models.dto.response.FactionDto;
import com.wff.ms.directory.models.dto.update.FactionUpdateDto;
import com.wff.ms.directory.models.entity.Faction;
import com.wff.ms.directory.modules.mappers.FactionMapper;
import com.wff.ms.directory.repositories.FactionRepo;
import com.wff.ms.directory.services.FactionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FactionServiceImpl implements FactionService {

  private final FactionRepo factionRepo;
  private final FactionMapper factionMapper;

  @Override
  public FactionDto create(FactionCreateDto factionCreateDto) {
    var faction = factionMapper.factionCreateDtoToFaction(factionCreateDto);
    faction = factionRepo.save(faction);
    return factionMapper.factionToFactionDto(faction);
  }

  @Override
  public FactionDto update(FactionUpdateDto factionUpdateDto) {
    Faction faction = findById(factionUpdateDto.getId());
    factionMapper.updateFaction(factionUpdateDto, faction);
    factionRepo.save(faction);
    return factionMapper.factionToFactionDto(faction);
  }

  @Override
  public List<FactionDto> getAll() {
    return factionRepo.findAll().stream().map(factionMapper::factionToFactionDto).toList();
  }

  @Override
  public FactionDto getById(Integer id) {
    return factionMapper.factionToFactionDto(findById(id));
  }

  @Override
  public void deleteById(Integer id) {
    factionRepo.delete(findById(id));
  }

  private Faction findById(Integer id) {
    return factionRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Faction doesn't found while searching by id: %d".formatted(id)));
  }
}
