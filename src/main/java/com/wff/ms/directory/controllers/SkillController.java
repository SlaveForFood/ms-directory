package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.SkillCreateDto;
import com.wff.ms.directory.models.dto.response.SkillDto;
import com.wff.ms.directory.models.dto.update.SkillUpdateDto;
import com.wff.ms.directory.services.SkillService;
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
@RequestMapping("/skills")
@Tag(name = "Умения", description = "Контроллер настройке умений")
public class SkillController {

  private final SkillService skillService;

  @Operation(summary = "Создание умения", description = "Создает умение")
  @PostMapping
  public ResponseEntity<SkillDto> create(@Valid @RequestBody SkillCreateDto skillCreateDto) {
    return ResponseEntity.status(201).body(skillService.create(skillCreateDto));
  }

  @Operation(summary = "Обновление умения", description = "Обновляет умение")
  @PutMapping
  public ResponseEntity<SkillDto> update(@Valid @RequestBody SkillUpdateDto skillUpdateDto) {
    return ResponseEntity.ok(skillService.update(skillUpdateDto));
  }

  @Operation(summary = "Получение умения", description = "Получает умение по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<SkillDto> getById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор умения", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(skillService.getById(id));
  }

  @Operation(summary = "Получение всех умений", description = "Возвращает список всех умений")
  @GetMapping
  public ResponseEntity<List<SkillDto>> getAll() {
    return ResponseEntity.ok(skillService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор умения", example = "1")
          @PathVariable
          Integer id) {
    skillService.deleteById(id);
  }
}
