package com.wff.ms.directory.models.dto.update;

import com.wff.ms.directory.models.dto.create.HeroCreateDto;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HeroUpdateDto {

  @NotNull(message = "Не указан id продукта")
  @Min(value = 1, message = "Id не может быть меньше 1")
  private Integer id;

  @Schema(description = "Обновленные поля")
  private HeroCreateDto updatedInfo;
}
