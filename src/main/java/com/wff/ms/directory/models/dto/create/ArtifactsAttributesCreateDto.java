package com.wff.ms.directory.models.dto.create;

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
@Schema(description = "Dto Создание связи артефактов и атрибутов")
public class ArtifactsAttributesCreateDto {

  @NotNull(message = "Field 'count' cannot be null")
  @Schema(description = "Значение связанного атрибута у артефакта", example = "15")
  private Integer count;

  @Min(value = 1, message = "Field 'artifactId' cannot be less than 1")
  @NotNull(message = "Field 'artifactId' cannot be null")
  @Schema(description = "Id артефакта", example = "1")
  private Integer artifactId;

  @Min(value = 1, message = "Field 'attributeId' cannot be less than 1")
  @NotNull(message = "Field 'attributeId' cannot be null")
  @Schema(description = "Id атрибута", example = "1")
  private Integer attributeId;
}
