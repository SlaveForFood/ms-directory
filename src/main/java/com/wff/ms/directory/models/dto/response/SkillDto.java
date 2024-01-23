package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto скила")
public class SkillDto {

  @Schema(description = "Id артефакта", example = "1")
  private Integer id;

  @Schema(description = "Наименование скила", example = "Skill")
  private String name;

  @Schema(description = "Описание скила", example = "Дает невидимость на х сек")
  private String description;
}
