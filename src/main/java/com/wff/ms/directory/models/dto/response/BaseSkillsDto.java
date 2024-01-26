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
@Schema(description = "Dto Базовые умения>")
public class BaseSkillsDto {

  @Schema(description = "Id Базового умения", example = "1")
  private Integer id;

  @Schema(description = "Наименование Базового умения", example = "Основы нападения")
  private String name;

  @Schema(description = "Тип родительского базового умения")
  private BaseSkillsDto parentBaseSkill;
}
