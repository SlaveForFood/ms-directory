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
@Schema(description = "Dto Связь героя и атрибута")
public class HeroesAttributesDto {

  @Schema(description = "Id связи героев и атрибутов", example = "1")
  private Integer id;

  @Schema(description = "Значение связанного атрибута у героя", example = "15")
  private Integer count;

  @Schema(description = "Герой")
  private HeroDto hero;

  @Schema(description = "Атрибут")
  private AttributeDto attribute;
}
