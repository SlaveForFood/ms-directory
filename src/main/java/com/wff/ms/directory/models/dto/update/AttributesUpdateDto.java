package com.wff.ms.directory.models.dto.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor

public class AttributesUpdateDto {

    @Min(value = 1, message = "Field 'id' cannot be less than 1")
    @NotNull(message = "Field 'id' cannot be null")
    @Schema(description = "Id атрибута", example = "1")
    private Integer id;

    @Schema(description = "Наименование атрибута", example = "Скорость")
    private String name;

    @Schema(description = "Проклятие?", example = "true")
    private Boolean isDebuff;

}