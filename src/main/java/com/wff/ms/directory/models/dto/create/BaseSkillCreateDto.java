package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto базовые умения")
public class BaseSkillCreateDto {

  @NotBlank(message = "Field 'name' cannot be null or empty")
  @Schema(description = "Наименование базовых умений", example = "Основы нападения")
  private String name;

  @NotBlank(message = "Field 'description' cannot be null or empty")
  @Schema(
      description = "Описание базового умения",
      example = "Урон, наносимый существами в ближнем бою, увеличивается на 5%")
  private String description;

  @Min(value = 1, message = "Field 'parentBaseId' cannot be less than 1")
  @Schema(description = "Id родительского базового умения", example = "1")
  private Integer parentBaseId;
}
