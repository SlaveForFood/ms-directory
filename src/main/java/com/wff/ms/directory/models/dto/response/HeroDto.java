package com.wff.ms.directory.models.dto.response;

import com.wff.ms.directory.models.entity.Faction;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Dto Героя")
public class HeroDto {

    @Schema(description = "Id героя", example = "1")
    private Integer id;

    @Schema(description = "Наименование героя", example = "Hero")
    private String name;

    @Schema(description = "Описание героя", example = "Description")
    private String description;

    @Schema(description = "Фракция", example = "Faction")
    private FactionDto faction;
}
