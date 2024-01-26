package com.wff.ms.directory.models.dto.create;


import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание тира")
public class TierCreateDto {

    @NotBlank(message = "Field 'name' cannot be null or empty")
    @Schema(description = "Наименование тира", example = "Высший")
    private String name;

    @NotBlank(message = "Field 'name' cannot be null or empty")
    @Schema(description = "Описание тира", example = "Высший тир")
    private String description;

}
