package com.wff.ms.directory.models.dto.update;

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
@Schema(description = "Dto Обновление связи героя и атрибута")
public class HeroesAttributesUpdateDto {

  @NotNull(message = "Field 'id' cannot be null")
  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @Schema(description = "Id связи героя и атрибута", example = "1")
  private Integer id;

  @Schema(description = "Значение связанного атрибута у героя", example = "15")
  private Integer count;

  @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
  @Schema(description = "Id героя")
  private Integer heroId;

  @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
  @Schema(description = "Id атрибута")
  private Integer attributeId;
}
