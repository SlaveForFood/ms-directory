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
@Schema(description = "Dto Связь артефакта и атрибута")
public class ArtifactsAttributesDto {

  @Schema(description = "Id связи артефакта и атрибута", example = "1")
  private Integer id;

  @Schema(description = "Значение связанного атрибута у артефакта", example = "15")
  private Integer count;

  @Schema(description = "Артефакт")
  private ArtifactDto artifact;

  @Schema(description = "Атрибут")
  private AttributeDto attribute;
}
