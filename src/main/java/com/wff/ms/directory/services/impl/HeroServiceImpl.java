package com.wff.ms.directory.services.impl;

import com.wff.ms.directory.models.dto.response.HeroDto;
import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import com.wff.ms.directory.models.entity.Hero;
import com.wff.ms.directory.modules.mappers.HeroMapper;
import com.wff.ms.directory.repositories.HeroRepo;
import com.wff.ms.directory.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroServiceImpl implements HeroService {
    private final HeroRepo heroRepo;
    private final HeroMapper heroMapper;

    @Override
    public HeroDto create(HeroCreateDto heroCreateDto) {
        Hero hero = heroRepo.save(heroMapper.mapToModel(heroCreateDto));
        return heroMapper.mapToEntity(hero);
    }

    @Override
    public List<HeroDto> getAll() {
        return heroRepo.findAll().stream().map(heroMapper::mapToEntity).toList();
    }

    @Override
    public HeroDto getById(Integer id) {
        return heroMapper.mapToEntity(heroRepo
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(
                        "Герой с id=%d не найден", id
                ))));
    }

    @Override
    public HeroDto update(HeroUpdateDto dto) {
        //getById(dto.getId());
        Hero hero = heroRepo.save(heroMapper.mapToModel(dto));
        return heroMapper.mapToEntity(hero);
    }

    @Override
    public void deleteById(Integer id) {
        heroRepo.delete(findById(id));
    }

    private Hero findById(Integer id){
        return heroRepo
                .findById(id)
                .orElseThrow(
                    ()->
                        new NotFoundException(
                        "Hero doesn't found while searching by id: %d".formatted(id)
                                )
                );
    }

}
