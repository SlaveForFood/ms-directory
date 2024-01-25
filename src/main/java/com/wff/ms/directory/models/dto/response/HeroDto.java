package com.wff.ms.directory.models.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {

    @Schema(description = "Id героя", example = "1")
    private Integer id;

    @Schema(description = "Наименование героя", example = "Hero")
    private String name;

    @Schema(description = "Описание героя", example = "Description")
    private String description;

    @Schema(description = "Id фракции", example = "2")
    private Integer factionID;
}
