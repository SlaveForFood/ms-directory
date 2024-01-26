package com.wff.ms.directory.models.dto.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class HeroesSkillsUpdateDto {
    @NotNull(message = "Не указан id heroToSkill")
    @Min(value=1,message = "Id не может быть меньше 1")
    @Schema(description = "Id heroToSkill", example = "1")
    private Integer id;

    @NotNull(message = "Не указан id героя")
    @Min(value=1,message = "Id не может быть меньше 1")
    @Schema(description = "Id hero",example = "1")
    private Integer heroId;

    @NotNull(message = "Не указан id навыка")
    @Min(value=1,message = "Id не может быть меньше 1")
    @Schema(description = "Id hero",example = "1")
    private Integer skillId;
}
