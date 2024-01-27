package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.BaseSkillCreateDto;
import com.wff.ms.directory.models.dto.response.BaseSkillDto;
import com.wff.ms.directory.models.dto.update.BaseSkillUpdateDto;
import com.wff.ms.directory.services.BaseSkillService;
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
@RequestMapping("/base-skills")
@Tag(name = "Базовые умения", description = "Контроллер по настройке базовых умений")
public class BaseSkillController {

  private final BaseSkillService baseSkillService;

  @Operation(
      summary = "Создание базовых умений",
      description = "Создает базовые умения и их описание")
  @PostMapping
  public ResponseEntity<BaseSkillDto> create(
      @Valid @RequestBody BaseSkillCreateDto baseSkillCreateDto) {
    return ResponseEntity.status(201).body(baseSkillService.create(baseSkillCreateDto));
  }

  @Operation(summary = "Обновление базовых умений", description = "Обновляет базовые умения")
  @PutMapping
  public ResponseEntity<BaseSkillDto> update(
      @Valid @RequestBody BaseSkillUpdateDto baseSkillUpdateDto) {
    return ResponseEntity.ok(baseSkillService.update(baseSkillUpdateDto));
  }

  @Operation(
      summary = "Получение базовых умений",
      description = "Получает базовые умения по их идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<BaseSkillDto> getById(
      @Valid
          @Min(value = 1, message = "Field 'id' cannot be less than 1")
          @Schema(description = "Идентификатор базовых умений", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(baseSkillService.getById(id));
  }

  @Operation(
      summary = "Получение всех базовых умений",
      description = "Возвращает список всех базовых умений")
  @GetMapping
  public ResponseEntity<List<BaseSkillDto>> getAll() {
    return ResponseEntity.ok(baseSkillService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'id' cannot be less than 1")
          @Schema(description = "Идентификатор базовых умений", example = "1")
          @PathVariable
          Integer id) {
    baseSkillService.deleteById(id);
  }
}
