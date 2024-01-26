package com.wff.ms.directory.models.dto.response;

import com.wff.ms.directory.models.entity.Attribute;
import com.wff.ms.directory.models.entity.Entities;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto связей сущуств и атрибутов")
public class EntitiesAttributesDto {

    @Schema(description = "Id связи сущуств и атрибутов", example = "1")
    private Integer id;

    @Schema(description = "Размер атрибута", example = "10")
    private Integer count;

    @Schema(description = "Существо")
    private Entities entitiesId;

    @Schema(description = "Атрибут")
    private Attribute attributeId;
}