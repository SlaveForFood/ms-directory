package com.wff.ms.directory.models.dto.update;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class HeroToSkillUpdateDto {
    @NotNull(message = "Не указан id продукта")
    @Min(value=1,message = "Id не может быть меньше 1")
    private Integer id;
}
