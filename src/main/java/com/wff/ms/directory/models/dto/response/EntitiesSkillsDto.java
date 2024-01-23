package com.wff.ms.directory.models.dto.response;

import com.wff.ms.directory.models.entity.Skill;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class EntitiesSkillsDto {
  @Schema(description = "Id связи существ и умений", example = "1")
  private Integer id;

  @Schema(description = "Список скилов")
  List<Skill> skills;
}
