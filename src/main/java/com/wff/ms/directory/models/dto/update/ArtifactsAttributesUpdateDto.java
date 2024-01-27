package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Обновление связи артефактов и атрибутов")
public class ArtifactsAttributesUpdateDto {

  @Schema(description = "Id связи артефактов и атрибутов", example = "1")
  private Integer id;

  @Schema(description = "Значение связанного атрибута у артефакта", example = "15")
  private Integer count;

  @Min(value = 1, message = "Field 'artifactId' cannot be less than 1")
  @Schema(description = "Id артефакта", example = "1")
  private Integer artifactId;

  @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
  @Schema(description = "Id атрибута", example = "1")
  private Integer attributeId;
}
