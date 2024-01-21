package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.response.ArtifactClassDto;
import com.wff.ms.directory.models.dto.update.ArtifactClassUpdateDto;
import com.wff.ms.directory.services.ArtifactClassService;
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
@RequestMapping("/artifact-classes")
@Tag(name = "Артефакты", description = "Контроллер по настройке классов артефактов")
public class ArtifactClassController {

  private final ArtifactClassService artifactClassService;

  @Operation(
      summary = "Создание класса артефакта",
      description = "Создает класс артефакта с указанным именем")
  @PostMapping
  public ResponseEntity<ArtifactClassDto> create(@Valid @RequestBody String name) {
    return ResponseEntity.status(201).body(artifactClassService.create(name));
  }

  @Operation(
      summary = "Обновление класса артефакта",
      description = "Обновляет имя класса артефакта с указанным id")
  @PutMapping
  public ResponseEntity<ArtifactClassDto> update(
      @Valid @RequestBody ArtifactClassUpdateDto artifactClassUpdateDto) {
    return ResponseEntity.ok(artifactClassService.update(artifactClassUpdateDto));
  }

  @Operation(summary = "Получение класса артефакта по id")
  @GetMapping("/{id}")
  public ResponseEntity<ArtifactClassDto> getByid(
      @Valid
          @Min(value = 1, message = "'id' cannot be less than 1")
          @Schema(description = "Идентификатор артефакта", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(artifactClassService.getById(id));
  }

  @Operation(
      summary = "Получение класса артефакта по имени",
      description = "Получает класс артефакта по его имени, без учета регистра")
  @GetMapping("/name/{name}")
  public ResponseEntity<ArtifactClassDto> getByName(
      @Valid
          @NotBlank(message = "'name' cannot be null or empty")
          @Schema(description = "Имя класса артефакта", example = "Artefact Type")
          @PathVariable
          String name) {
    return ResponseEntity.ok(artifactClassService.getByName(name));
  }

  @Operation(
      summary = "Получение всех классов артефактов",
      description = "Возвращает список всех классов артефактов")
  @GetMapping
  public ResponseEntity<List<ArtifactClassDto>> getAll() {
    return ResponseEntity.ok(artifactClassService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "'id' cannot be less than 1")
          @Schema(description = "Идентификатор класса артефакта", example = "1")
          @PathVariable
          Integer id) {
    artifactClassService.deleteById(id);
  }
}
