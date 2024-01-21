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
@Schema(description = "Dto Класс артефакта")
public class ArtifactClassDto {

  @Schema(description = "Id класса артефакта", example = "1")
  private Integer id;

  @Schema(description = "Наименование класса артефакта", example = "Artifact Class")
  private String name;
}
