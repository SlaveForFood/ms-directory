package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.create.HeroesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesSkillsDto;
import com.wff.ms.directory.models.dto.update.HeroesSkillsUpdateDto;
import com.wff.ms.directory.models.entity.HeroesSkills;
import com.wff.ms.directory.modules.mappers.HeroesSkillsMapper;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.repositories.HeroesSkillsRepo;
import com.wff.ms.directory.repositories.SkillRepo;
import com.wff.ms.directory.services.HeroesSkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HeroesSkillsServiceImpl implements HeroesSkillsService {
    private final HeroesSkillsRepo heroesSkillsRepo;
    private final HeroesSkillsMapper heroesSkillsMapper;
    private final HeroRepo heroRepo;
    private final SkillRepo skillRepo;
    @Override
    public HeroesSkillsDto create(HeroesSkillsCreateDto heroesSkillsCreateDto) {
        HeroesSkills heroesSkills = heroesSkillsRepo.save(heroesSkillsMapper.HeroesSkillsCreateDtoToHeroesSkills(heroesSkillsCreateDto));

        var hero =
                heroRepo
                        .findById(heroesSkillsCreateDto.getHeroId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an heroesSkills with type not exist. heroId: %d"
                                                        .formatted(heroesSkillsCreateDto.getHeroId())
                                        )
                        );
        var skill =
                skillRepo
                        .findById(heroesSkillsCreateDto.getSkillId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an heroesSkills with type not exist. skillId: %d"
                                                        .formatted(heroesSkillsCreateDto.getSkillId())
                                        )
                        );
        heroesSkills.setHero(hero);
        heroesSkills.setSkill(skill);

        heroesSkills = heroesSkillsRepo.save(heroesSkills);

        return heroesSkillsMapper.HeroesSkillToHeroesSkillsDto(heroesSkills);
    }

    @Override
    public List<HeroesSkillsDto> getAll() {
        return heroesSkillsRepo.findAll().stream().map(heroesSkillsMapper::HeroesSkillToHeroesSkillsDto).toList();
    }

    @Override
    public HeroesSkillsDto getById(Integer id) {
        return heroesSkillsMapper.HeroesSkillToHeroesSkillsDto(heroesSkillsRepo
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(
                        "Связь героя и навыка с id=%d не найден", id
                ))));
    }

    @Override
    public HeroesSkillsDto update(HeroesSkillsUpdateDto dto) {
        Integer id = dto.getId();
        HeroesSkills heroesSkills = findById(id);
        Integer heroId = dto.getHeroId();
        if (Objects.nonNull(heroId)) {
            var hero =
                    heroRepo
                            .findById(heroId)
                            .orElseThrow(
                                    () ->
                                            new com.wff.ms.directory.exceptions.NotFoundException(
                                                    "Trying to update an heroesSkills with type not exist. Hero id: %d, typeId: %d"
                                                            .formatted(id, heroId)));
            heroesSkills.setHero(hero);
        }
        Integer skillId = dto.getSkillId();
        if (Objects.nonNull(skillId)) {
            var skill =
                    skillRepo
                            .findById(skillId)
                            .orElseThrow(
                                    () ->
                                            new com.wff.ms.directory.exceptions.NotFoundException(
                                                    "Trying to update an heroesSkills with class not exist. Skill id: %d, clazzId: %d"
                                                            .formatted(id, skillId)));
            heroesSkills.setSkill(skill);
        }
        heroesSkillsMapper.updateHeroesSkills(dto, heroesSkills);
        HeroesSkills hero = heroesSkillsRepo.save(heroesSkills);
        return heroesSkillsMapper.HeroesSkillToHeroesSkillsDto(hero);
    }

    @Override
    public void deleteById(Integer id) {
        heroesSkillsRepo.delete(findById(id));
    }

    private HeroesSkills findById(Integer id){
        return heroesSkillsRepo
                .findById(id)
                .orElseThrow(
                        ()->
                                new NotFoundException(
                                        "HeroesSkills doesn't found while searching by id: %d".formatted(id)
                                )
                );
    }
}
