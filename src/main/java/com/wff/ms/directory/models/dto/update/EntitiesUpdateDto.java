package com.wff.ms.directory.models.dto.update;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor

public class EntitiesUpdateDto {

    @Min(value = 1, message = "Field 'id' cannot be less than 1")
    @NotNull(message = "Field 'id' cannot be null")
    @Schema(description = "Id существа", example = "1")
    private Integer id;

    @Schema(description = "Наименование существа", example = "Абобус")
    private String name;

    @Schema(description = "Стоимость существа", example = "200")
    private Integer cost;

    @Min(value = 1, message = "Field 'tierId' cannot be less than 1")
    @Schema(description = "Id тира существа", example = "1")
    private Integer tierId;

}
