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
@Schema(description = "Dto Существа")
public class EntitiDto {

  @Schema(description = "Id существа", example = "1")
  private Integer id;

  @Schema(description = "Наименование существа", example = "Entiti")
  private String name;

  @Schema(description = "Стоимость существа", example = "200")
  private Integer cost;

  @Schema(description = "Тиp существа")
  private TierDto tier;
}
