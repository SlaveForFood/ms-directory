package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
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
public class ArtifactCreateDto {

  @NotBlank(message = "Field 'name' cannot be null or empty")
  @Schema(description = "Наименование артефакта", example = "Кольцо Бильбо")
  private String name;

  @NotNull(message = "Field 'cost' cannot be null")
  @Schema(description = "Стоимость артефакта", example = "1000")
  private Integer cost;

  @NotNull(message = "Field 'isSalable' cannot be null")
  @Schema(description = "Продаваемый ли (доступен к покупке) артефакт", example = "true")
  private Boolean isSalable;

  @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
  @NotNull(message = "Field 'typeId' cannot be null")
  @Schema(description = "Id типа артефакта", example = "1")
  private Integer typeId;

  @Min(value = 1, message = "Field 'clazzId' cannot be less than 1")
  @NotNull(message = "Field 'clazzId' cannot be null")
  @Schema(description = "Id класса артефакта", example = "1")
  private Integer clazzId;
}
