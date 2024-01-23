package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntitiesSkillsUpdateDto {
  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id связи существ и умений", example = "1")
  private Integer id;
}
