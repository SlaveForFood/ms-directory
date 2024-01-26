package com.wff.ms.directory.controllers;


import com.wff.ms.directory.models.dto.create.AttributeCreateDto;
import com.wff.ms.directory.models.dto.response.AttributeDto;
import com.wff.ms.directory.models.dto.update.AttributesUpdateDto;
import com.wff.ms.directory.services.AttributeService;
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
@RequestMapping("/attributes")
@Tag(name = "Атрибуты", description = "Контроллер по настройке атрибутов")
public class AttributeController {

    private final AttributeService attributeService;

    @Operation(
            summary = "Создание атрибутов",
            description = "Создает атрибуты")
    @PostMapping
    public ResponseEntity<AttributeDto> create(
            @Valid @RequestBody AttributeCreateDto attributeCreateDto) {
        return ResponseEntity.status(201).body(attributeService.create(attributeCreateDto));
    }

    @Operation(summary = "Обновление атрибута", description = "Обновляет атрибут")
    @PutMapping
    public ResponseEntity<AttributeDto> update(
            @Valid @RequestBody AttributesUpdateDto attributesUpdateDto) {
        return ResponseEntity.ok(attributeService.update(attributesUpdateDto));
    }

    @Operation(
            summary = "Получение атрибута",
            description = "Получает атрибут по его идентификатору")
    @GetMapping("/{id}")
    public ResponseEntity<AttributeDto> getByid(
            @Valid
            @Min(value = 1, message = "Field 'Id' cannot be less than 1")
            @Schema(description = "Идентификатор атрибута", example = "1")
            @PathVariable
            Integer id) {
        return ResponseEntity.ok(attributeService.getById(id));
    }

    @Operation(
            summary = "Получение всех атрибутов",
            description = "Возвращает список всех атрибутов")
    @GetMapping
    public ResponseEntity<List<AttributeDto>> getAll() {
        return ResponseEntity.ok(attributeService.getAll());
    }

    @DeleteMapping("/{id}")
    public void deleteById(
            @Valid
            @Min(value = 1, message = "Field 'Id' cannot be less than 1")
            @Schema(description = "Идентификатор атрибута", example = "1")
            @PathVariable
            Integer id) {
        attributeService.deleteById(id);
    }
}