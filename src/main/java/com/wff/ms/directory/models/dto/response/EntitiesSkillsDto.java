package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto связи существ и умений")
public class EntitiesSkillsDto {

  @Schema(description = "Id связи существ и умений", example = "1")
  private Integer id;

  @Schema(description = "Сущность")
  EntitiesDto entitiDto;

  @Schema(description = "Умение")
  SkillDto skill;
}
