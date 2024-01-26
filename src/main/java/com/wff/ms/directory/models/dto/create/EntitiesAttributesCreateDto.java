package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание связей сущуств и атрибутов")
public class EntitiesAttributesCreateDto {

    @NotNull(message = "Field 'cost' cannot be null")
    @Schema(description = "Стоимость артефакта", example = "10")
    private Integer count;

    @Min(value = 1, message = "Field 'entitiesId' cannot be less than 1")
    @NotNull(message = "Field 'entitiesId' cannot be null")
    @Schema(description = "Id Существа", example = "1")
    private Integer entitiesId;

    @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
    @NotNull(message = "Field 'attributeId' cannot be null")
    @Schema(description = "Id атрибута", example = "1")
    private Integer attributeId;
}
