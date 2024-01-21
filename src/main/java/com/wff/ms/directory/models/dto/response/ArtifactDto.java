package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Артефакт")
public class ArtifactDto {

  @Schema(description = "Id артефакта", example = "1")
  private Integer id;

  @Schema(description = "Наименование артефакта", example = "Artifact")
  private String name;

  @Schema(description = "Стоимость артефакта", example = "1000")
  private Integer cost;

  @Schema(description = "Продаваемый ли (доступный к покупке) артефакт", example = "true")
  private Boolean isSalable;

  @Schema(description = "Тип артефакта")
  private ArtifactTypeDto type;

  @Schema(description = "Класс артефакта")
  private ArtifactClassDto clazz;
}
