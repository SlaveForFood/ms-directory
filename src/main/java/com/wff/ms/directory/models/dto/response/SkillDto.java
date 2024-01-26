package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto умения")
public class SkillDto {

  @Schema(description = "Id умения", example = "1")
  private Integer id;

  @Schema(description = "Наименование умения", example = "Огненный шар")
  private String name;

  @Schema(description = "Описание умения", example = "Дает невидимость на х сек")
  private String description;

  @Schema(description = "Родительоское умение")
  private SkillDto parentSkill;
}
