package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.ArtifactsAttributesCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactsAttributesDto;
import com.wff.ms.directory.models.dto.update.ArtifactsAttributesUpdateDto;
import com.wff.ms.directory.services.ArtifactsAttributesService;
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
@RequestMapping("/artifacts-attributes")
@Tag(
    name = "Связи артефактов и атрибутов",
    description = "Контроллер по настройке связи артефактов и атрибутов")
public class ArtifactsAttributesController {

  private final ArtifactsAttributesService artifactsAttributesService;

  @Operation(
      summary = "Создание cвязи артефактов и атрибутов",
      description = "Создает cвязи артефактов и атрибутов")
  @PostMapping
  public ResponseEntity<ArtifactsAttributesDto> create(
      @Valid @RequestBody ArtifactsAttributesCreateDto artifactsAttributesCreateDto) {
    return ResponseEntity.status(201)
        .body(artifactsAttributesService.create(artifactsAttributesCreateDto));
  }

  @Operation(
      summary = "Обновление cвязи артефактов и атрибутов",
      description = "Обновляет cвязи артефактов и атрибутов")
  @PutMapping
  public ResponseEntity<ArtifactsAttributesDto> update(
      @Valid @RequestBody ArtifactsAttributesUpdateDto artifactsAttributesUpdateDto) {
    return ResponseEntity.ok(artifactsAttributesService.update(artifactsAttributesUpdateDto));
  }

  @Operation(
      summary = "Получение cвязи артефактов и атрибутов",
      description = "Получает cвязь артефактов и атрибутов по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<ArtifactsAttributesDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи артефактов и атрибутов", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(artifactsAttributesService.getById(id));
  }

  @Operation(
      summary = "Получение всех cвязей артефактов и атрибутов",
      description = "Возвращает список всех cвязей артефактов и атрибутов")
  @GetMapping
  public ResponseEntity<List<ArtifactsAttributesDto>> getAll() {
    return ResponseEntity.ok(artifactsAttributesService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор cвязи артефактов и атрибутов", example = "1")
          @PathVariable
          Integer id) {
    artifactsAttributesService.deleteById(id);
  }
}
