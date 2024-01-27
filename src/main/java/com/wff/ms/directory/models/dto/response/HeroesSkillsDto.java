package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Сущность описывающая связи героев и навыков")
public class HeroesSkillsDto {

  @Schema(description = "Id связи между героем и", example = "1")
  private Integer id;

  @Schema(description = "Герой")
  private HeroDto hero;

  @Schema(description = "Навык")
  private SkillDto skill;
}
