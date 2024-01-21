package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import com.wff.ms.directory.modules.mappers.HeroMapper;
import com.wff.ms.directory.services.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes")
@Tag(name="Герои",description="\"Контроллер по добавлению и настройке героев\"")

public class HeroController {

    private final HeroService heroService;
    private final HeroMapper heroMapper;
    @Operation(summary="Добавление героя",
                    description="Создает героя с переданными характеристиками")
    @PostMapping("/")
    public ResponseEntity<Integer> create(@Valid @RequestBody HeroCreateDto heroCreateDto){
        // ResponseEntity<HeroDto> предлагал, но не пойму зачем возвращать героя
        // Если можно вернуть ID героя
        return ResponseEntity.status(201).body(heroService.create(heroMapper.mapToModel(heroCreateDto)));
    }
}
