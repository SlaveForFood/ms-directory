package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.response.HeroDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.modules.mappers.HeroMapper;
import com.wff.ms.directory.repositories.FactionRepo;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.services.HeroService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {

  private final HeroRepo heroRepo;
  private final HeroMapper heroMapper;
  private final FactionRepo factionRepo;

  @Override
  public HeroDto create(HeroCreateDto heroCreateDto) {
    Hero hero = heroRepo.save(heroMapper.heroCreateDtoToHero(heroCreateDto));
    return heroMapper.heroToHeroDto(hero);
  }

  @Override
  public List<HeroDto> getAll() {
    return heroRepo.findAll().stream().map(heroMapper::heroToHeroDto).toList();
  }

  @Override
  public HeroDto getById(Integer id) {
    return heroMapper.heroToHeroDto(
        heroRepo
            .findById(id)
            .orElseThrow(
                () -> new NotFoundException(String.format("Герой с id=%d не найден", id))));
  }

  @Override
  public HeroDto update(HeroUpdateDto dto) {
    Integer id = dto.getId();
    Hero hero = findById(id);
    Integer factionId = dto.getUpdatedInfo().getFactionID();
    if (Objects.nonNull(factionId)) {
      var faction =
          factionRepo
              .findById(factionId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an hero with type not exist. Hero id: %d, factionId: %d"
                              .formatted(id, factionId)));
      hero.setFaction(faction);
    }
    heroMapper.updateHero(dto, hero);
    Hero updatedHero = heroRepo.save(hero);
    return heroMapper.heroToHeroDto(updatedHero);
  }

  @Override
  public void deleteById(Integer id) {
    heroRepo.delete(findById(id));
  }

  private Hero findById(Integer id) {
    return heroRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "Hero doesn't found while searching by id: %d".formatted(id)));
  }
}
