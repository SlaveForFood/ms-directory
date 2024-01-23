package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание скила")
public class SkillCreateDto {

  @NotBlank(message = "Field 'name' cannot be null or empty")
  @Size(max = 50, message = "Поле \"name\" ограничено 50 символами")
  @Schema(description = "Наименование скила", example = "Огненый шар")
  private String name;

  @Size(max = 255, message = "Поле \"description\" ограничено 255 символами")
  private String description;
}
