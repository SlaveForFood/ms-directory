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
@Schema(description = "Dto Тип артефакта")
public class ArtifactTypeDto {

  @Schema(description = "Id типа артефакта", example = "1")
  private Integer id;

  @Schema(description = "Наименование типа артефакта", example = "Artifact Type")
  private String name;
}
