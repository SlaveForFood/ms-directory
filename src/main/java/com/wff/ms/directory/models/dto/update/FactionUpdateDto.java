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
@Schema(description = "Dto Обновление фракции")
public class FactionUpdateDto {

  @Min(value = 1, message = "Field 'id' cannot be less than 1")
  @NotNull(message = "Field 'id' cannot be null")
  @Schema(description = "Id Фракции", example = "1")
  private Integer id;

  @Schema(description = "Наименование фракции", example = "Олимп")
  private String name;

  @Schema(
      description = "Описание фракции",
      example = "На Олимпе живет Зевс и другие греческие боги")
  private String description;
}
