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
@Schema(description = "Dto Обновление базового умения")
public class BaseSkillUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id базового умения", example = "1")
  private Integer id;

  @Schema(description = "Наименование базовых умений", example = "Основы нападения")
  private String name;

  @Schema(
      description = "Описание базового умения",
      example = "Урон, наносимый существами в ближнем бою, увеличивается на 5%")
  private String description;

  @Min(value = 1, message = "Field 'parentBaseId' cannot be less than 1")
  @Schema(description = "Id родительского базового умения", example = "1")
  private Integer parentBaseId;
}
