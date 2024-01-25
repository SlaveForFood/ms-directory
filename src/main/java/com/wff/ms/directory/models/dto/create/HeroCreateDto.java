package com.wff.ms.directory.models.dto.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Создание героя")
public class HeroCreateDto {

    @Size(max=50, message="Поле \"name\" ограничено 50 символами")
    @NotBlank(message="Поле \"name\" должно иметь хотя бы один символ (не пробел)")
    @Schema(description = "Наименование героя")
    private String name;

    @Size(max=500, message="Поле \"description\" ограничено 500 символами")
    @Schema(description = "Описание героя")
    private String description;

    @Min(value = 1, message = "Field 'skillId' cannot be less than 1")
    @NotNull(message = "Field 'skillId' cannot be null")
    @Schema(description = "Id Фракции", example = "1")
    private Integer factionID;

}