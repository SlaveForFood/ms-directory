package com.wff.ms.directory.models.dto.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
public class HeroCreateDto {

    @NotNull(message = "Не указан id героя")
    @Min(value = 1, message = "Id не может быть меньше 1")
    private Integer heroID;

    @Size(max=50, message="Поле \"name\" ограничено 50 символами")
    @NotBlank(message="Поле \"name\" должно иметь хотя бы один символ (не пробел)")
    private String name;

    @Size(max=500, message="Поле \"description\" ограничено 500 символами")
    private String description;

    // Нужно связать фракцию
    //private Integer factionID;

}