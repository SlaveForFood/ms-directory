package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.create.HeroToSkillCreateDto;
import com.wff.ms.directory.models.dto.response.HeroToSkillDto;
import com.wff.ms.directory.models.dto.update.HeroToSkillUpdateDto;
import com.wff.ms.directory.models.entity.HeroToSkill;
import com.wff.ms.directory.modules.mappers.HeroToSkillMapper;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.repositories.HeroToSkillRepo;
import com.wff.ms.directory.repositories.SkillRepo;
import com.wff.ms.directory.services.HeroToSkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HeroToSkillServiceImpl implements HeroToSkillService {
    private final HeroToSkillRepo heroToSkillRepo;
    private final HeroToSkillMapper heroToSkillMapper;
    private final HeroRepo heroRepo;
    private final SkillRepo skillRepo;
    @Override
    public HeroToSkillDto create(HeroToSkillCreateDto heroToSkillCreateDto) {
        HeroToSkill heroToSkill = heroToSkillRepo.save(heroToSkillMapper.mapToModel(heroToSkillCreateDto));

        var hero =
                heroRepo
                        .findById(heroToSkillCreateDto.getHeroId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an heroToSkill with type not exist. heroId: %d"
                                                        .formatted(heroToSkillCreateDto.getHeroId())
                                        )
                        );
        var skill =
                skillRepo
                        .findById(heroToSkillCreateDto.getSkillId())
                        .orElseThrow(
                                () ->
                                        new NotFoundException(
                                                "Trying to create an heroToSkill with type not exist. skillId: %d"
                                                        .formatted(heroToSkillCreateDto.getSkillId())
                                        )
                        );
        heroToSkill.setHero(hero);
        heroToSkill.setSkill(skill);

        heroToSkill = heroToSkillRepo.save(heroToSkill);

        return heroToSkillMapper.mapToEntity(heroToSkill);
    }

    @Override
    public List<HeroToSkillDto> getAll() {
        return heroToSkillRepo.findAll().stream().map(heroToSkillMapper::mapToEntity).toList();
    }

    @Override
    public HeroToSkillDto getById(Integer id) {
        return heroToSkillMapper.mapToEntity(heroToSkillRepo
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(
                        "Связь героя и навыка с id=%d не найден", id
                ))));
    }

    @Override
    public HeroToSkillDto update(HeroToSkillUpdateDto dto) {
        Integer id = dto.getId();
        HeroToSkill heroToSkill = findById(id);
        Integer heroId = dto.getHeroId();
        if (Objects.nonNull(heroId)) {
            var hero =
                    heroRepo
                            .findById(heroId)
                            .orElseThrow(
                                    () ->
                                            new com.wff.ms.directory.exceptions.NotFoundException(
                                                    "Trying to update an heroToSkill with type not exist. Hero id: %d, typeId: %d"
                                                            .formatted(id, heroId)));
            heroToSkill.setHero(hero);
        }
        Integer skillId = dto.getSkillId();
        if (Objects.nonNull(skillId)) {
            var skill =
                    skillRepo
                            .findById(skillId)
                            .orElseThrow(
                                    () ->
                                            new com.wff.ms.directory.exceptions.NotFoundException(
                                                    "Trying to update an heroToSkill with class not exist. Skill id: %d, clazzId: %d"
                                                            .formatted(id, skillId)));
            heroToSkill.setSkill(skill);
        }
        heroToSkillMapper.updateHeroToSkill(dto,heroToSkill);
        HeroToSkill hero = heroToSkillRepo.save(heroToSkill);
        return heroToSkillMapper.mapToEntity(hero);
    }

    @Override
    public void deleteById(Integer id) {
        heroToSkillRepo.delete(findById(id));
    }

    private HeroToSkill findById(Integer id){
        return heroToSkillRepo
                .findById(id)
                .orElseThrow(
                        ()->
                                new NotFoundException(
                                        "HeroToSkill doesn't found while searching by id: %d".formatted(id)
                                )
                );
    }
}
