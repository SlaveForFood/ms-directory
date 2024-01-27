package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.EntitiCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiDto;
import com.wff.ms.directory.models.dto.update.EntitiUpdateDto;
import com.wff.ms.directory.services.EntitiService;
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
@RequestMapping("/entities")
@Tag(name = "Существа", description = "Контроллер по настройке существ")
public class EntitiesController {

  private final EntitiService entitiService;

  @Operation(summary = "Создание существа", description = "Создает существо указанного тира")
  @PostMapping
  public ResponseEntity<EntitiDto> create(
      @Valid @RequestBody EntitiCreateDto entitiCreateDto) {
    return ResponseEntity.status(201).body(entitiService.create(entitiCreateDto));
  }

  @Operation(summary = "Обновление существа", description = "Обновляет существо")
  @PutMapping
  public ResponseEntity<EntitiDto> update(
      @Valid @RequestBody EntitiUpdateDto entitiUpdateDto) {
    return ResponseEntity.ok(entitiService.update(entitiUpdateDto));
  }

  @Operation(
      summary = "Получение существа",
      description = "Получает существо по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<EntitiDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор артефакта", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(entitiService.getById(id));
  }

  @Operation(summary = "Получение всех существ", description = "Возвращает список всех существ")
  @GetMapping
  public ResponseEntity<List<EntitiDto>> getAll() {
    return ResponseEntity.ok(entitiService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор существа", example = "1")
          @PathVariable
          Integer id) {
    entitiService.deleteById(id);
  }
}
