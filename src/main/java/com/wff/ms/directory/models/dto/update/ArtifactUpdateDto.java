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
@Schema(description = "Dto Обновление артефакта")
public class ArtifactUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id артефакта", example = "1")
  private Integer id;

  @Schema(description = "Наименование артефакта", example = "Нагрудник воина")
  private String name;

  @Schema(description = "Описание артефакта", example = "Герой получает +2 к защите")
  private String description;

  @Schema(description = "Стоимость артефакта", example = "5000")
  private Integer cost;

  @Schema(description = "Продаваемый ли (доступный к покупке) артефакт", example = "true")
  private Boolean isSalable;

  @Min(value = 1, message = "Field 'typeId' cannot be less than 1")
  @Schema(description = "Id типа артефакта", example = "1")
  private Integer typeId;

  @Min(value = 1, message = "Field 'clazzId' cannot be less than 1")
  @Schema(description = "Id класса артефакта", example = "1")
  private Integer clazzId;
}
