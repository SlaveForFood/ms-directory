package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Фракции")
public class FactionCreateDto {

  @NotBlank(message = "Field 'name' cannot be null or empty")
  @Schema(description = "Наименование фракции", example = "Олимп")
  private String name;

  @NotBlank(message = "Field 'description' cannot be null or empty")
  @Schema(
      description = "Описание фракции",
      example = "На Олимпе живет Зевс и другие греческие боги")
  private String description;
}
