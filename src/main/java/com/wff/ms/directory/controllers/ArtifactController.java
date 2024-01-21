package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.ArtifactCreateDto;
import com.wff.ms.directory.models.dto.response.ArtifactDto;
import com.wff.ms.directory.models.dto.update.ArtifactUpdateDto;
import com.wff.ms.directory.services.ArtifactService;
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
@RequestMapping("/artifacts")
@Tag(name = "Артефакты", description = "Контроллер по настройке артефактов")
public class ArtifactController {

  private final ArtifactService artifactService;

  @Operation(
      summary = "Создание артефакта",
      description = "Создает артефакт указанного типа и класса")
  @PostMapping
  public ResponseEntity<ArtifactDto> create(
      @Valid @RequestBody ArtifactCreateDto artifactCreateDto) {
    return ResponseEntity.status(201).body(artifactService.create(artifactCreateDto));
  }

  @Operation(summary = "Обновление артефакта", description = "Обновляет артефакт")
  @PutMapping
  public ResponseEntity<ArtifactDto> update(
      @Valid @RequestBody ArtifactUpdateDto artifactUpdateDto) {
    return ResponseEntity.ok(artifactService.update(artifactUpdateDto));
  }

  @Operation(
      summary = "Получение артефакта",
      description = "Получает артефакт по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<ArtifactDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор артефакта", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(artifactService.getById(id));
  }

  @Operation(
      summary = "Получение всех артефактов",
      description = "Возвращает список всех артефактов")
  @GetMapping
  public ResponseEntity<List<ArtifactDto>> getAll() {
    return ResponseEntity.ok(artifactService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор артефакта", example = "1")
          @PathVariable
          Integer id) {
    artifactService.deleteById(id);
  }
}
