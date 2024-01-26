package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Обновление связи фракции и базового умения")
public class FactionsBaseSkillsUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id Связи фракции и базового умения", example = "1")
  private Integer id;

  @Schema(description = "id фракции", example = "1")
  private Integer factionId;

  @Schema(description = "Id базового умения", example = "1")
  private Integer baseSkillId;
}
