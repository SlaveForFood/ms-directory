package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание артефакта")
public class EntitiesCreateDto {

    @NotBlank(message = "Field 'name' cannot be null or empty")
    @Schema(description = "Наименование существа", example = "Абобус")
    private String name;

    @NotNull(message = "Field 'cost' cannot be null")
    @Schema(description = "Стоимость существа", example = "200")
    private Integer cost;

    @Min(value = 1, message = "Field 'tierId' cannot be less than 1")
    @NotNull(message = "Field 'tierId' cannot be null")
    @Schema(description = "Id тир существа", example = "1")
    private Integer tierId;

}
