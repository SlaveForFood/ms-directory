package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Обновление связи героев и артефактов")
public class HeroesArtifactsCreateDto {

  @Min(value = 1, message = "Field 'heroId' cannot be less than 1")
  @NotNull(message = "Field 'heroId' cannot be null")
  @Schema(description = "Id героя", example = "1")
  private Integer heroId;

  @Min(value = 1, message = "Field 'artifactId' cannot be less than 1")
  @NotNull(message = "Field 'artifactId' cannot be null")
  @Schema(description = "Id артефакта", example = "1")
  private Integer artifactId;
}
