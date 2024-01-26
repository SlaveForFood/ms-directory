package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Обновление скила")
public class SkillUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id скила", example = "1")
  private Integer id;

  @Schema(description = "Наименование скила", example = "Skill")
  private String name;

  @Schema(description = "Описание скила", example = "Дает невидимость на х сек")
  private String description;
}
