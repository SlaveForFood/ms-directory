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
@Schema(description = "Dto Обновление связи артефактов и атрибутов")
public class HeroesAttributesCreateDto {

  @Min(value = 1, message = "Field 'count' cannot be less than 1")
  @NotNull(message = "Field 'count' cannot be null")
  @Schema(description = "Значение связанного атрибута у героя", example = "15")
  private Integer count;

  @Min(value = 1, message = "Field 'heroId' cannot be less than 1")
  @NotNull(message = "Field 'heroId' cannot be null")
  @Schema(description = "Id героя")
  private Integer heroId;

  @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
  @NotNull(message = "Field 'attributeId' cannot be null")
  @Schema(description = "Id атрибута")
  private Integer attributeId;
}
