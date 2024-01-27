package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto обновления связи существ и умений")
public class EntitiesSkillsUpdateDto {

  @NotNull(message = "Не указан id heroToSkill")
  @Min(value = 1, message = "Id не может быть меньше 1")
  @Schema(description = "Id Связи существ и умений", example = "1")
  private Integer id;

  @NotNull(message = "Не указан id героя")
  @Min(value = 1, message = "Id не может быть меньше 1")
  @Schema(description = "Id существа", example = "1")
  private Integer entitiId;

  @NotNull(message = "Не указан id навыка")
  @Min(value = 1, message = "Id не может быть меньше 1")
  @Schema(description = "Id умения", example = "1")
  private Integer skillId;
}
