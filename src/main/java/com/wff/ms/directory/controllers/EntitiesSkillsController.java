package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.EntitiesSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesSkillsDto;
import com.wff.ms.directory.models.dto.update.EntitiesSkillsUpdateDto;
import com.wff.ms.directory.services.EntitiesSkillsService;
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
@RequestMapping("/entities-skills")
@Tag(
    name = "Связь существ и умений",
    description = "\"Контроллер по настройке связи существ и умений\"")
public class EntitiesSkillsController {

  private final EntitiesSkillsService entitiesSkillsService;

  @Operation(
      summary = "Создание связи существ и умений",
      description = "Создает связь с переданным существом и умением")
  @PostMapping
  public ResponseEntity<EntitiesSkillsDto> create(
      @Valid @RequestBody EntitiesSkillsCreateDto entitiesSkillsCreateDto) {
    return ResponseEntity.status(201).body(entitiesSkillsService.create(entitiesSkillsCreateDto));
  }

  @Operation(
      summary = "Обновление связи существ и умений",
      description = "Обновляет связь существ и умений")
  @PutMapping
  public ResponseEntity<EntitiesSkillsDto> update(
      @Valid @RequestBody EntitiesSkillsUpdateDto entitiesSkillsUpdateDto) {
    return ResponseEntity.ok(entitiesSkillsService.update(entitiesSkillsUpdateDto));
  }

  @Operation(
      summary = "Получить информаю о герое",
      description = "Получить информацию о герое по id.")
  @GetMapping("/{id}")
  public ResponseEntity<EntitiesSkillsDto> getById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор связи существ и умений", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(entitiesSkillsService.getById(id));
  }

  @Operation(
      summary = "Получение всех связей существ и умений",
      description = "Возвращает список связей существ и умений")
  @GetMapping
  public ResponseEntity<List<EntitiesSkillsDto>> getAll() {
    return ResponseEntity.ok(entitiesSkillsService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор героя", example = "1")
          @PathVariable
          Integer id) {
    entitiesSkillsService.deleteById(id);
  }
}
