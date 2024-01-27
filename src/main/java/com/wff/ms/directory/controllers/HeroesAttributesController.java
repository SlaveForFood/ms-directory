package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.HeroesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesAttributesDto;
import com.wff.ms.directory.models.dto.update.HeroesAttributesUpdateDto;
import com.wff.ms.directory.services.HeroesAttributesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/heroes-attributes")
@Tag(
    name = "Связи героев и атрибутов",
    description = "Контроллер по настройке связи героев и атрибутов")
public class HeroesAttributesController {

  private final HeroesAttributesService heroesAttributesService;

  @Operation(
      summary = "Создание cвязи героев и атрибутов",
      description = "Создает cвязи героев и атрибутов")
  @PostMapping
  public ResponseEntity<HeroesAttributesDto> create(
      @Valid @RequestBody HeroesAttributesCreateDto heroesAttributesCreateDto) {
    return ResponseEntity.status(201)
        .body(heroesAttributesService.create(heroesAttributesCreateDto));
  }

  @Operation(
      summary = "Обновление cвязи героев и атрибутов",
      description = "Обновляет cвязи героев и атрибутов")
  @PutMapping
  public ResponseEntity<HeroesAttributesDto> update(
      @Valid @RequestBody HeroesAttributesUpdateDto heroesAttributesUpdateDto) {
    return ResponseEntity.ok(heroesAttributesService.update(heroesAttributesUpdateDto));
  }

  @Operation(
      summary = "Получение cвязи героев и атрибутов",
      description = "Получает cвязь героев и атрибутов по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<HeroesAttributesDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи героев и атрибутов", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(heroesAttributesService.getById(id));
  }

  @Operation(
      summary = "Получение всех cвязей героев и атрибутов",
      description = "Возвращает список всех cвязей героев и атрибутов")
  @GetMapping
  public ResponseEntity<List<HeroesAttributesDto>> getAll() {
    return ResponseEntity.ok(heroesAttributesService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи героев и атрибутов", example = "1")
          @PathVariable
          Integer id) {
    heroesAttributesService.deleteById(id);
  }
}
