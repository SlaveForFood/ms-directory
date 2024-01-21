package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.HeroDto;
import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import com.wff.ms.directory.models.dto.update.HeroUpdateDto;
import com.wff.ms.directory.services.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes")
@Tag(name = "Герои", description = "\"Контроллер по добавлению и настройке героев\"")

public class HeroController {

    private final HeroService heroService;

    @Operation(summary = "Добавление героя",
            description = "Создает героя с переданными характеристиками")
    @PostMapping("/")
    public ResponseEntity<HeroDto> create(@Valid @RequestBody HeroCreateDto heroCreateDto) {
        return ResponseEntity.status(201).body(heroService.create(heroCreateDto));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить информаю о герое",
        description = "Получить информацию о герое по id.")
    public ResponseEntity<HeroDto> getHeroById(
        @PathVariable @Valid @Min(value=1,message = "Id не может быть меньше 1") Integer id
    ){
        return ResponseEntity.status(201).body(heroService.getById(id));
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Отредактировать информацию о герое",
        description = "В информации о герое будут заменены поля переданными параметрами.")
    public String update(@Valid @RequestBody HeroUpdateDto dto){
        return heroService.update(dto);
    }
}
