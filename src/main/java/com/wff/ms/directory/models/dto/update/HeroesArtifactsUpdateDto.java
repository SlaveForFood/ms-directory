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
@Schema(description = "Dto Обновление связи героя и артефакта")
public class HeroesArtifactsUpdateDto {

  @NotNull(message = "Field 'id' cannot be null")
  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @Schema(description = "Id связи героя и артефакта", example = "1")
  private Integer id;

  @Min(value = 1, message = "Field 'heroId' cannot be less than 1")
  @Schema(description = "Id героя", example = "1")
  private Integer heroId;

  @Min(value = 1, message = "Field 'artifactId' cannot be less than 1")
  @Schema(description = "Id артефакта", example = "1")
  private Integer artifactId;
}
