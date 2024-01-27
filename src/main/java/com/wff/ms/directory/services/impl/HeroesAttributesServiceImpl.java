package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.exceptions.NotFoundException;
import com.wff.ms.directory.models.dto.create.HeroesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesAttributesDto;
import com.wff.ms.directory.models.dto.update.HeroesAttributesUpdateDto;
import com.wff.ms.directory.models.entity.HeroesAttributes;
import com.wff.ms.directory.modules.mappers.HeroesAttributesMapper;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.repositories.HeroesAttributesRepo;
import com.wff.ms.directory.repositories.AttributeRepo;
import com.wff.ms.directory.services.HeroesAttributesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Реализация интерфейса {@link HeroesAttributesService}
 *
 * @author Orlov
 * @since 01.2024
 */
@Service
@RequiredArgsConstructor
public class HeroesAttributesServiceImpl implements HeroesAttributesService {

  private final HeroesAttributesRepo heroesAttributesRepo;
  private final HeroesAttributesMapper heroesAttributesMapper;
  private final HeroRepo heroRepo;
  private final AttributeRepo attributeRepo;

  @Override
  public HeroesAttributesDto create(HeroesAttributesCreateDto heroesAttributesCreateDto) {
    HeroesAttributes heroesAttributes =
        heroesAttributesMapper.heroesAttributesCreateDtoToHeroesAttributes(
            heroesAttributesCreateDto);
    var hero =
        heroRepo
            .findById(heroesAttributesCreateDto.getHeroId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an HeroesAttributes with hero not exist. heroId: %d"
                            .formatted(heroesAttributesCreateDto.getHeroId())));
    var attribute =
        attributeRepo
            .findById(heroesAttributesCreateDto.getAttributeId())
            .orElseThrow(
                () ->
                    new NotFoundException(
                        "Trying to create an artifact with type not exist. typeId: %d"
                            .formatted(heroesAttributesCreateDto.getAttributeId())));
    heroesAttributes.setHero(hero);
    heroesAttributes.setAttribute(attribute);
    heroesAttributes = heroesAttributesRepo.save(heroesAttributes);
    return heroesAttributesMapper.heroesAttributesToHeroesAttributesDto(heroesAttributes);
  }

  @Override
  public List<HeroesAttributesDto> getAll() {
    return heroesAttributesRepo.findAll().stream()
        .map(heroesAttributesMapper::heroesAttributesToHeroesAttributesDto)
        .toList();
  }

  @Override
  public HeroesAttributesDto getById(Integer id) {
    return heroesAttributesMapper.heroesAttributesToHeroesAttributesDto(findById(id));
  }

  @Override
  public HeroesAttributesDto update(HeroesAttributesUpdateDto heroesAttributesUpdateDto) {
    Integer heroesAttributesId = heroesAttributesUpdateDto.getId();
    HeroesAttributes heroesAttributes = findById(heroesAttributesId);
    Integer heroId = heroesAttributesUpdateDto.getHeroId();
    if (Objects.nonNull(heroId)) {
      var hero =
          heroRepo
              .findById(heroId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an HeroesAttributes with artifact not exist. HeroesAttributes id: %d, heroId: %d"
                              .formatted(heroesAttributesId, heroId)));
      heroesAttributes.setHero(hero);
    }
    Integer attributeId = heroesAttributesUpdateDto.getAttributeId();
    if (Objects.nonNull(attributeId)) {
      var attribute =
          attributeRepo
              .findById(attributeId)
              .orElseThrow(
                  () ->
                      new NotFoundException(
                          "Trying to update an HeroesAttributes with attribute not exist. HeroesAttributes id: %d, attributeId: %d"
                              .formatted(heroesAttributesId, attributeId)));
      heroesAttributes.setAttribute(attribute);
    }
    heroesAttributesMapper.updateHeroesAttributes(heroesAttributesUpdateDto, heroesAttributes);
    heroesAttributesRepo.save(heroesAttributes);
    return heroesAttributesMapper.heroesAttributesToHeroesAttributesDto(heroesAttributes);
  }

  @Override
  public void deleteById(Integer id) {
    heroesAttributesRepo.delete(findById(id));
  }

  private HeroesAttributes findById(Integer id) {
    return heroesAttributesRepo
        .findById(id)
        .orElseThrow(
            () ->
                new NotFoundException(
                    "HeroesAttributes doesn't found while searching by id: %d".formatted(id)));
  }
}
