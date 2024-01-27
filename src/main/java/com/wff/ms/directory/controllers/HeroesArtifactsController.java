package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.HeroesArtifactsCreateDto;
import com.wff.ms.directory.models.dto.response.HeroesArtifactsDto;
import com.wff.ms.directory.models.dto.update.HeroesArtifactsUpdateDto;
import com.wff.ms.directory.services.HeroesArtifactsService;
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
@RequestMapping("/heroes-artifacts")
@Tag(
    name = "Связи героев и артефактов",
    description = "Контроллер по настройке связи героев и артефактов")
public class HeroesArtifactsController {

  private final HeroesArtifactsService heroesArtifactsService;

  @Operation(
      summary = "Создание cвязи героев и артефактов",
      description = "Создает cвязи героев и артефактов")
  @PostMapping
  public ResponseEntity<HeroesArtifactsDto> create(
      @Valid @RequestBody HeroesArtifactsCreateDto heroesArtifactsCreateDto) {
    return ResponseEntity.status(201).body(heroesArtifactsService.create(heroesArtifactsCreateDto));
  }

  @Operation(
      summary = "Обновление cвязи героев и артефактов",
      description = "Обновляет cвязи героев и артефактов")
  @PutMapping
  public ResponseEntity<HeroesArtifactsDto> update(
      @Valid @RequestBody HeroesArtifactsUpdateDto heroesArtifactsUpdateDto) {
    return ResponseEntity.ok(heroesArtifactsService.update(heroesArtifactsUpdateDto));
  }

  @Operation(
      summary = "Получение cвязи героев и артефактов",
      description = "Получает cвязь героев и артефактов по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<HeroesArtifactsDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи героев и артефактов", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(heroesArtifactsService.getById(id));
  }

  @Operation(
      summary = "Получение всех cвязей героев и артефактов",
      description = "Возвращает список всех cвязей героев и артефактов")
  @GetMapping
  public ResponseEntity<List<HeroesArtifactsDto>> getAll() {
    return ResponseEntity.ok(heroesArtifactsService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи героев и артефактов", example = "1")
          @PathVariable
          Integer id) {
    heroesArtifactsService.deleteById(id);
  }
}
