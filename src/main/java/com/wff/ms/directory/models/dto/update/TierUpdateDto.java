package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor

public class TierUpdateDto {

    @Min(value = 1, message = "Field 'id' cannot be less than 1")
    @NotNull(message = "Field 'id' cannot be null")
    @Schema(description = "Id тира", example = "1")
    private Integer id;

    @Schema(description = "Наименование тира", example = "Высший")
    private String name;

    @Schema(description = "Описание тира", example = "Самый высший")
    private Integer description;

}