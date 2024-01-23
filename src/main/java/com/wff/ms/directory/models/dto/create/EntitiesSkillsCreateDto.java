package com.wff.ms.directory.models.dto.create;

import com.wff.ms.directory.models.entity.Skill;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание связи существ и умений")
public class EntitiesSkillsCreateDto {

  @Schema(description = "Список скилов")
  private List<Skill> skills;
}
