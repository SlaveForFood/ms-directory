package com.wff.ms.directory.controllers;

import com.wff.ms.directory.models.dto.create.EntitiesCreateDto;
import com.wff.ms.directory.models.dto.response.EntitiesDto;
import com.wff.ms.directory.models.dto.update.EntitiesUpdateDto;
import com.wff.ms.directory.services.EntitiesService;
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

    private final EntitiesService entitiesService;

    @Operation(
            summary = "Создание существа",
            description = "Создает существо указанного тира")
    @PostMapping
    public ResponseEntity<EntitiesDto> create(
            @Valid @RequestBody EntitiesCreateDto entitiesCreateDto) {
        return ResponseEntity.status(201).body(entitiesService.create(entitiesCreateDto));
    }

    @Operation(summary = "Обновление существа", description = "Обновляет существо")
    @PutMapping
    public ResponseEntity<EntitiesDto> update(
            @Valid @RequestBody EntitiesUpdateDto entitiesUpdateDto) {
        return ResponseEntity.ok(entitiesService.update(entitiesUpdateDto));
    }

    @Operation(
            summary = "Получение существа",
            description = "Получает существо по его идентификатору")
    @GetMapping("/{id}")
    public ResponseEntity<EntitiesDto> getByid(
            @Valid
            @Min(value = 1, message = "Field 'Id' cannot be less than 1")
            @Schema(description = "Идентификатор артефакта", example = "1")
            @PathVariable
            Integer id) {
        return ResponseEntity.ok(entitiesService.getById(id));
    }

    @Operation(
            summary = "Получение всех существ",
            description = "Возвращает список всех существ")
    @GetMapping
    public ResponseEntity<List<EntitiesDto>> getAll() {
        return ResponseEntity.ok(entitiesService.getAll());
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @Valid
            @Min(value = 1, message = "Field 'Id' cannot be less than 1")
            @Schema(description = "Идентификатор существа", example = "1")
            @PathVariable
            Integer id) {
        entitiesService.deleteById(id);
    }
}
