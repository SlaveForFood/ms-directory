package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание артефакта")
public class AttributeCreateDto {

  @NotBlank(message = "Field 'name' cannot be null or empty")
  @Schema(description = "Наименование атрибута", example = "Скорость")
  private String name;

  @NotNull(message = "Field 'isDebuff' cannot be null")
  @Schema(description = "Проклятие?", example = "true")
  private Boolean isDebuff;
}
