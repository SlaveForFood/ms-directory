package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.HeroesArtifactsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesArtifactsDto;
import com.wff.ms.directory.models.dto.update.HeroesArtifactsUpdateDto;
import com.wff.ms.directory.models.entity.HeroesArtifacts;
import com.wff.ms.directory.modules.mappers.HeroesArtifactsMapper;
import com.wff.ms.directory.repositories.ArtifactRepo;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.repositories.HeroesArtifactsRepo;
import com.wff.ms.directory.services.HeroesArtifactsService;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация интерфейса {@link HeroesArtifactsService}
 *
 * @author Orlov
 * @since 01.2024
 */
@Service
@RequiredArgsConstructor
public class HeroesArtifactsServiceImpl implements HeroesArtifactsService {

  private final HeroesArtifactsRepo heroesArtifactsRepo;
  private final HeroesArtifactsMapper heroesArtifactsMapper;
  private final HeroRepo heroRepo;
  private final ArtifactRepo attributeRepo;

  @Override
  public HeroesArtifactsDto create(HeroesArtifactsCreateDto heroesArtifactsCreateDto) {
    HeroesArtifacts heroesArtifacts =
        heroesArtifactsMapper.heroesArtifactsCreateDtoToHeroesArtifacts(heroesArtifactsCreateDto);
    var hero =
        heroRepo
            .findById(heroesArtifactsCreateDto.getHeroId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an HeroesArtifacts with hero not exist. heroId: %d"
                            .formatted(heroesArtifactsCreateDto.getHeroId())));
    var attribute =
        attributeRepo
            .findById(heroesArtifactsCreateDto.getArtifactId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an artifact with type not exist. typeId: %d"
                            .formatted(heroesArtifactsCreateDto.getArtifactId())));
    heroesArtifacts.setHero(hero);
    heroesArtifacts.setArtifact(attribute);
    heroesArtifacts = heroesArtifactsRepo.save(heroesArtifacts);
    return heroesArtifactsMapper.heroesArtifactsToHeroesArtifactsDto(heroesArtifacts);
  }

  @Override
  public List<HeroesArtifactsDto> getAll() {
    return heroesArtifactsRepo.findAll().stream()
        .map(heroesArtifactsMapper::heroesArtifactsToHeroesArtifactsDto)
        .toList();
  }

  @Override
  public HeroesArtifactsDto getById(Integer id) {
    return heroesArtifactsMapper.heroesArtifactsToHeroesArtifactsDto(findById(id));
  }

  @Override
  public HeroesArtifactsDto update(HeroesArtifactsUpdateDto heroesArtifactsUpdateDto) {
    Integer heroesArtifactsId = heroesArtifactsUpdateDto.getId();
    HeroesArtifacts heroesArtifacts = findById(heroesArtifactsId);
    Integer heroId = heroesArtifactsUpdateDto.getHeroId();
    if (Objects.nonNull(heroId)) {
      var hero =
          heroRepo
              .findById(heroId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an HeroesArtifacts with hero not exist. HeroesArtifacts id: %d, heroId: %d"
                              .formatted(heroesArtifactsId, heroId)));
      heroesArtifacts.setHero(hero);
    }
    Integer attributeId = heroesArtifactsUpdateDto.getArtifactId();
    if (Objects.nonNull(attributeId)) {
      var attribute =
          attributeRepo
              .findById(attributeId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an HeroesArtifacts with artifact not exist. HeroesArtifacts id: %d, artifactId: %d"
                              .formatted(heroesArtifactsId, attributeId)));
      heroesArtifacts.setArtifact(attribute);
    }
    heroesArtifactsMapper.updateHeroesArtifacts(heroesArtifactsUpdateDto, heroesArtifacts);
    heroesArtifactsRepo.save(heroesArtifacts);
    return heroesArtifactsMapper.heroesArtifactsToHeroesArtifactsDto(heroesArtifacts);
  }

  @Override
  public void deleteById(Integer id) {
    heroesArtifactsRepo.delete(findById(id));
  }

  private HeroesArtifacts findById(Integer id) {
    return heroesArtifactsRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "HeroesArtifacts doesn't found while searching by id: %d".formatted(id)));
  }
}
