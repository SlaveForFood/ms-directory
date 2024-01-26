package com.wff.ms.directory.models.dto.update;

import com.wff.ms.directory.models.entity.Attribute;
import com.wff.ms.directory.models.entity.Entities;
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
@Schema(description = "Dto Обновление связей сущуств и атрибутов")
public class EntitiesAttributesUpdateDto {

    @Min(value = 1, message = "Field 'id' cannot be less than 1")
    @NotNull(message = "Field 'id' cannot be null")
    @Schema(description = "Id связей сущуств и атрибутов", example = "1")
    private Integer id;

    @Schema(description = "Размер атрибута", example = "10")
    private Integer count;

    @Min(value = 1, message = "Field 'entitiesId' cannot be less than 1")
    @Schema(description = "Id существа", example = "1")
    private Integer entitiesId;

    @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
    @Schema(description = "Id атрибута", example = "1")
    private Integer attributeId;
}
