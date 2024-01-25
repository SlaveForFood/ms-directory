package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.HeroToSkillCreateDto;
import com.wff.ms.directory.models.dto.response.HeroToSkillDto;
import com.wff.ms.directory.models.dto.update.HeroToSkillUpdateDto;
import com.wff.ms.directory.services.HeroToSkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroToSkill")
@Tag(name = "Связь героев и навыков", description = "\"Контроллер по добавлению и настройке связей между героями и навыками\"")
public class HeroToSkillController {

    private final HeroToSkillService heroToSkillService;

    @Operation(summary = "Добавление связей между героем и навыком",
            description = "Создает связь с переданным героем и навыком")
    @PostMapping("/")
    public ResponseEntity<HeroToSkillDto> create(@Valid @RequestBody HeroToSkillCreateDto heroToSkillCreateDto) {
        return ResponseEntity.status(201).body(heroToSkillService.create(heroToSkillCreateDto));
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить информаю о герое",
            description = "Получить информацию о герое по id.")
    public ResponseEntity<HeroToSkillDto> getById(
            @PathVariable @Valid @Min(value=1,message = "Id не может быть меньше 1") Integer id
    ){
        return ResponseEntity.status(201).body(heroToSkillService.getById(id));
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Отредактировать информацию о герое",
            description = "В информации о герое будут заменены поля переданными параметрами.")
    public HeroToSkillDto update(@Valid @RequestBody HeroToSkillUpdateDto dto){
        return heroToSkillService.update(dto);
    }

    @Operation(
            summary = "Получение всех героев",
            description = "Возвращает список всех героев")
    @GetMapping
    public ResponseEntity<List<HeroToSkillDto>> getAll(){ return ResponseEntity.ok(heroToSkillService.getAll());}

    @DeleteMapping("/{id}")
    public void deleteById(
            @Valid
            @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
            @Schema(description = "Идентификатор героя",example = "1")
            @PathVariable
            Integer id){
        heroToSkillService.deleteById(id);
    }
}
