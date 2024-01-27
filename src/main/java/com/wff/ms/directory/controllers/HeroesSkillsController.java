package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.HeroesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesSkillsDto;
import com.wff.ms.directory.models.dto.update.HeroesSkillsUpdateDto;
import com.wff.ms.directory.services.HeroesSkillsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes-skills")
@Tag(
    name = "Связь героев и умений",
    description = "Контроллер по добавлению и настройке связей между героями и умениями")
public class HeroesSkillsController {

  private final HeroesSkillsService heroesSkillsService;

  @Operation(
      summary = "Добавление связей между героем и умением",
      description = "Создает связь по переданным id героя и умения")
  @PostMapping("/")
  public ResponseEntity<HeroesSkillsDto> create(
      @Valid @RequestBody HeroesSkillsCreateDto heroesSkillsCreateDto) {
    return ResponseEntity.status(201).body(heroesSkillsService.create(heroesSkillsCreateDto));
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Получить информацию о связи героя и умения",
      description = "Получить информацию о связи героя и умения по id.")
  public ResponseEntity<HeroesSkillsDto> getById(
      @PathVariable @Valid @Min(value = 1, message = "Id не может быть меньше 1") Integer id) {
    return ResponseEntity.status(201).body(heroesSkillsService.getById(id));
  }

  @PutMapping("/")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Отредактировать информацию о герое",
      description = "В информации о герое будут заменены поля переданными параметрами.")
  public HeroesSkillsDto update(@Valid @RequestBody HeroesSkillsUpdateDto dto) {
    return heroesSkillsService.update(dto);
  }

  @Operation(
      summary = "Получение всех героев ",
      description = "Возвращает список всех связей героев и умений")
  @GetMapping
  public ResponseEntity<List<HeroesSkillsDto>> getAll() {
    return ResponseEntity.ok(heroesSkillsService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор связи героя и умения", example = "1")
          @PathVariable
          Integer id) {
    heroesSkillsService.deleteById(id);
  }
}
