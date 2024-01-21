package com.wff.ms.directory.models.dto.update;

import com.wff.ms.directory.models.dto.EntitiesSkillsCreateDto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntitiesSkillsUpdateDto {
    @NotNull(message = "Не указан id скила существ")
    @Min(value = 1, message = "Id не может быть меньше 1")
    private Integer id;

    private EntitiesSkillsCreateDto updatedInfo;
}
