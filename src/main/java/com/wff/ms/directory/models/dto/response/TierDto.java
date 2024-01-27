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
@Schema(description = "Dto Тир")
public class TierDto {

  @Schema(description = "Id тира", example = "1")
  private Integer id;

  @Schema(description = "Наименование тира", example = "Tier")
  private String name;

  @Schema(description = "Описание тира", example = "The highest shooting tier")
  private String description;
}
