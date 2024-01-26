package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Атрибута")
public class AttributeDto {

    @Schema(description = "Id атрибута", example = "1")
    private Integer id;

    @Schema(description = "Наименование атрибута", example = "Speed")
    private String name;

    @Schema(description = "Проклятие?", example = "true")
    private Boolean isDebuff;

}