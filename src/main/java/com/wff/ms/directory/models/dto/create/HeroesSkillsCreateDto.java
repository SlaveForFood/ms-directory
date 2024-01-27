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
@Schema(description = "Dto Создание связей между героями и навыками")
public class HeroesSkillsCreateDto {

  @Min(value = 1, message = "Field 'heroId' cannot be less than 1")
  @NotNull(message = "Field 'heroId' cannot be null")
  @Schema(description = "Id героя", example = "1")
  private Integer heroId;

  @Min(value = 1, message = "Field 'skillId' cannot be less than 1")
  @NotNull(message = "Field 'skillId' cannot be null")
  @Schema(description = "Id навыка", example = "1")
  private Integer skillId;
}
