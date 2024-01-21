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
@Schema(description = "Dto Обновления типа артефакта")
public class ArtifactTypeUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id типа артефакта", example = "1")
  private Integer id;

  @NotNull(message = "Field 'name' cannot be null")
  @Schema(description = "Наименование типа артефакта", example = "Artifact Type")
  private String name;
}
