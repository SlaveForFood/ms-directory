package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание умения")
public class SkillCreateDto {

  @NotBlank(message = "Field 'name' cannot be null or empty")
  @Size(max = 50, message = "Field 'name': max length 50")
  @Schema(description = "Наименование умения", example = "Огненный шар")
  private String name;

  @Size(max = 255, message = "Field 'description': max length 255")
  @Schema(description = "Описание умения", example = "Пускает огненный шар")
  private String description;
}
