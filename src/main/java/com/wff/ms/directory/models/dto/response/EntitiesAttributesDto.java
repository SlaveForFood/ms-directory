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
@Schema(description = "Dto связей существ и атрибутов")
public class EntitiesAttributesDto {

  @Schema(description = "Id связи существ и атрибутов", example = "1")
  private Integer id;

  @Schema(description = "Значение атрибута у существа", example = "10")
  private Integer count;

  @Schema(description = "Существо")
  private EntitiDto entiti;

  @Schema(description = "Атрибут")
  private AttributeDto attribute;
}
