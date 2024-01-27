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
@Schema(description = "Dto Базовые умения доступные фракции>")
public class FactionsBaseSkillsDto {

  @Schema(description = "Id связи фракции и базовго умения", example = "1")
  private Integer id;

  @Schema(description = "Фракция", example = "1")
  private FactionDto factionDto;

  @Schema(description = "Базовое умения", example = "1")
  private BaseSkillDto baseSkillDto;
}
