package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание связи существ и умений")
public class EntitiesSkillsCreateDto {

  @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
  @NotNull(message = "Field 'typeId' cannot be null")
  @Schema(description = "Id существа", example = "1")
  private Integer entitiId;

  @Min(value = 1, message = "Field 'clazzId' cannot be less than 1")
  @NotNull(message = "Field 'clazzId' cannot be null")
  @Schema(description = "Id умения", example = "1")
  private Integer skillId;
}
