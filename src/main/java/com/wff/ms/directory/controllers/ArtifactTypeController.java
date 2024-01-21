package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.response.ArtifactTypeDto;
import com.wff.ms.directory.models.dto.update.ArtifactTypeUpdateDto;
import com.wff.ms.directory.services.ArtifactTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artifact-types")
@Tag(name = "Артефакты", description = "Контроллер по настройке типов артефактов")
public class ArtifactTypeController {

  private final ArtifactTypeService artifactTypeService;

  @Operation(
      summary = "Создание типа артефакта",
      description = "Создает тип артефакта с указанным именем")
  @PostMapping
  public ResponseEntity<ArtifactTypeDto> create(@Valid @RequestBody String name) {
    return ResponseEntity.status(201).body(artifactTypeService.create(name));
  }

  @Operation(
      summary = "Обновление типа артефакта",
      description = "Обновляет имя типа артефакта с указанным id")
  @PutMapping
  public ResponseEntity<ArtifactTypeDto> update(
      @Valid @RequestBody ArtifactTypeUpdateDto artifactTypeUpdateDto) {
    return ResponseEntity.ok(artifactTypeService.update(artifactTypeUpdateDto));
  }

  @Operation(summary = "Получение типа артефакта по id")
  @GetMapping("/{id}")
  public ResponseEntity<ArtifactTypeDto> getByid(
      @Valid
          @Min(value = 1, message = "'id' cannot be less than 1")
          @Schema(description = "Идентификатор типа артефакта", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(artifactTypeService.getById(id));
  }

  @Operation(
      summary = "Получение типа артефакта по имени",
      description = "Получает тип артефакта по его имени, без учета регистра")
  @GetMapping("/name/{name}")
  public ResponseEntity<ArtifactTypeDto> getByName(
      @Valid
          @NotBlank(message = "'name' cannot be null or empty")
          @Schema(description = "Имя типа артефакта", example = "Artefact Type")
          @PathVariable
          String name) {
    return ResponseEntity.ok(artifactTypeService.getByName(name));
  }

  @Operation(
      summary = "Получение всех типов артефактов",
      description = "Возвращает список всех типов артефактов")
  @GetMapping
  public ResponseEntity<List<ArtifactTypeDto>> getAll() {
    return ResponseEntity.ok(artifactTypeService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "'id' cannot be less than 1")
          @Schema(description = "Идентификатор типа артефакта", example = "1")
          @PathVariable
          Integer id) {
    artifactTypeService.deleteById(id);
  }
}
