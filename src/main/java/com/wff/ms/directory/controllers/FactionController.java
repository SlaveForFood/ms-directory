package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.FactionCreateDto;
import com.wff.ms.directory.models.dto.response.FactionDto;
import com.wff.ms.directory.models.dto.update.FactionUpdateDto;
import com.wff.ms.directory.services.FactionService;
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
@RequestMapping("/factions")
@Tag(name = "Фракции", description = "Контроллер по настройке фракций")
public class FactionController {

  private final FactionService factionService;

  @Operation(summary = "Создание фракции", description = "Создает фракцию и её описание")
  @PostMapping
  public ResponseEntity<FactionDto> create(@Valid @RequestBody FactionCreateDto factionCreateDto) {
    return ResponseEntity.status(201).body(factionService.create(factionCreateDto));
  }

  @Operation(summary = "Обновление фракции", description = "Обновляет фракцию")
  @PutMapping
  public ResponseEntity<FactionDto> update(@Valid @RequestBody FactionUpdateDto factionUpdateDto) {
    return ResponseEntity.ok(factionService.update(factionUpdateDto));
  }

  @Operation(summary = "Получение фракции", description = "Получает фракцию по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<FactionDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор фракции", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(factionService.getById(id));
  }

  @Operation(summary = "Получение всех фракций", description = "Возвращает список всех фракций")
  @GetMapping
  public ResponseEntity<List<FactionDto>> getAll() {
    return ResponseEntity.ok(factionService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
          @Schema(description = "Идентификатор фракций", example = "1")
          @PathVariable
          Integer id) {
    factionService.deleteById(id);
  }
}
