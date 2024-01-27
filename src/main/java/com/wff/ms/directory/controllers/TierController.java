package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.TierCreateDto;
import com.wff.ms.directory.models.dto.response.TierDto;
import com.wff.ms.directory.models.dto.update.TierUpdateDto;
import com.wff.ms.directory.services.TierService;
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
@RequestMapping("/tiers")
@Tag(name = "Тиры", description = "Контроллер по настройке тиров")
public class TierController {

  private final TierService tierService;

  @Operation(summary = "Создание тиров", description = "Создает тир")
  @PostMapping
  public ResponseEntity<TierDto> create(@Valid @RequestBody TierCreateDto tierCreateDto) {
    return ResponseEntity.status(201).body(tierService.create(tierCreateDto));
  }

  @Operation(summary = "Обновление тира", description = "Обновляет тир")
  @PutMapping
  public ResponseEntity<TierDto> update(@Valid @RequestBody TierUpdateDto tierUpdateDto) {
    return ResponseEntity.ok(tierService.update(tierUpdateDto));
  }

  @Operation(summary = "Получение тира", description = "Получает тир по его идентификатору")
  @GetMapping("/{id}")
  public ResponseEntity<TierDto> getByid(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор тира", example = "1")
          @PathVariable
          Integer id) {
    return ResponseEntity.ok(tierService.getById(id));
  }

  @Operation(summary = "Получение всех тиров", description = "Возвращает список всех тиров")
  @GetMapping
  public ResponseEntity<List<TierDto>> getAll() {
    return ResponseEntity.ok(tierService.getAll());
  }

  @DeleteMapping("/{id}")
  public void deleteById(
      @Valid
          @Min(value = 1, message = "Field 'Id' cannot be less than 1")
          @Schema(description = "Идентификатор тира", example = "1")
          @PathVariable
          Integer id) {
    tierService.deleteById(id);
  }
}
