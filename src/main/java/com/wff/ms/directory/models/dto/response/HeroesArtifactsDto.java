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
@Schema(description = "Dto Связь героя и артефакта")
public class HeroesArtifactsDto {

  @Schema(description = "Id связи героев и артефакта", example = "1")
  private Integer id;

  @Schema(description = "Герой")
  private HeroDto hero;

  @Schema(description = "артефакт")
  private ArtifactDto artifact;
}
