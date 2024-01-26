package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.FactionsBaseSkillsCreateDto;
import com.wff.ms.directory.models.dto.response.FactionsBaseSkillsDto;
import com.wff.ms.directory.models.dto.update.FactionsBaseSkillsUpdateDto;
import com.wff.ms.directory.services.FactionsBaseSkillsService;
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
@RequestMapping("/factions-base-skills")
@Tag(name = "Фракции", description = "Контроллер по настройке базовых умений фракций")
public class FactionBaseSkillsController {

  private final FactionsBaseSkillsService factionsBaseSkillsService;

  @Operation(
      summary = "Создание базовых умений фракции",
      description = "Создает базовые умения фракции и их описание")
  @PostMapping
  public ResponseEntity<FactionsBaseSkillsDto> create(
      @Valid @RequestBody FactionsBaseSkillsCreateDto factionBaseSkillCreateDto) {
    return ResponseEntity.status(201)
        .body(factionsBaseSkillsService.create(factionBaseSkillCreateDto));
  }

  @Operation(
      summary = "Обновление базовых умений фракции",
      description = "Обновляет базовые умения фракции")
  @PutMapping
  public ResponseEntity<FactionsBaseSkillsDto> update(
      @Valid @RequestBody FactionsBaseSkillsUpdateDto factionBaseSkillUpdateDto) {
    return ResponseEntity.ok(factionsBaseSkillsService.update(factionBaseSkillUpdateDto));
  }

  @Operation(
      summary = "Получение базовых умений фракции",
      description = "Получает базовые умения фракции по их идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<FactionsBaseSkillsDto> getById(
      @Valid
          @Min(value = 1, message = "Field 'id' cannot be less than 1")
          @Schema(description = "Идентификатор базовых умений фракции", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(factionsBaseSkillsService.getById(id));
  }

  @Operation(
      summary = "Получение всех базовых умений фракции",
      description = "Возвращает список всех базовых умений фракции")
  @GetMapping
  public ResponseEntity<List<FactionsBaseSkillsDto>> getAll() {
    return ResponseEntity.ok(factionsBaseSkillsService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'id' cannot be less than 1")
          @Schema(description = "Идентификатор базовых умений фракции", example = "1")
          @PathVariable
          Integer id) {
    factionsBaseSkillsService.deleteById(id);
  }
}
