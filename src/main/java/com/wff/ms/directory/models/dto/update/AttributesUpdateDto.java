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
public class AttributesUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id атрибута", example = "1")
  private Integer id;

  @Schema(description = "Наименование атрибута", example = "Скорость")
  private String name;

  @Schema(description = "Проклятие?", example = "true")
  private Boolean isDebuff;
}
