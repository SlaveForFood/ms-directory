package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.EntitiesAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesAttributesDto;
import com.wff.ms.directory.models.dto.update.EntitiesAttributesUpdateDto;
import com.wff.ms.directory.services.EntitiesAttributesService;
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
@RequestMapping("/entities-attributes")
@Tag(
    name = "Связи существ и атрибутов",
    description = "Контроллер по настройке связи существ и атрибутов")
public class EntitiesAttributesController {

  private final EntitiesAttributesService entitiesAttributesService;

  @Operation(
      summary = "Создание cвязи существ и атрибутов",
      description = "Создает cвязи существ и атрибутов")
  @PostMapping
  public ResponseEntity<EntitiesAttributesDto> create(
      @Valid @RequestBody EntitiesAttributesCreateDto entitiesAttributesCreateDto) {
    return ResponseEntity.status(201)
        .body(entitiesAttributesService.create(entitiesAttributesCreateDto));
  }

  @Operation(
      summary = "Обновление cвязи существ и атрибутов",
      description = "Обновляет cвязи существ и атрибутов")
  @PutMapping
  public ResponseEntity<EntitiesAttributesDto> update(
      @Valid @RequestBody EntitiesAttributesUpdateDto entitiesAttributesUpdateDto) {
    return ResponseEntity.ok(entitiesAttributesService.update(entitiesAttributesUpdateDto));
  }

  @Operation(
      summary = "Получение cвязи существ и атрибутов",
      description = "Получает cвязь существ и атрибутов по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<EntitiesAttributesDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи существ и атрибутов", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(entitiesAttributesService.getById(id));
  }

  @Operation(
      summary = "Получение всех cвязей существ и атрибутов",
      description = "Возвращает список всех cвязей существ и атрибутов")
  @GetMapping
  public ResponseEntity<List<EntitiesAttributesDto>> getAll() {
    return ResponseEntity.ok(entitiesAttributesService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи существ и атрибутов", example = "1")
          @PathVariable
          Integer id) {
    entitiesAttributesService.deleteById(id);
  }
}
