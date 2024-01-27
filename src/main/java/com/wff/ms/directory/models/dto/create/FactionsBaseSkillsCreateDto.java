package com.wff.ms.directory.models.dto.create;

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
@Schema(description = "Dto Связь фракции с базовыми умениями")
public class FactionsBaseSkillsCreateDto {

  @Min(value = 1, message = "Field 'factionId' cannot be less than 1")
  @NotNull(message = "Field 'factionId' cannot be null")
  @Schema(description = "id фракции", example = "1")
  private Integer factionId;

  @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
  @NotNull(message = "Field 'typeId' cannot be null")
  @Schema(description = "Id базового умения", example = "1")
  private Integer baseSkillId;
}
