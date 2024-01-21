package com.wff.ms.directory.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SkillCreateDto {

  @Size(max = 50, message = "Поле \"name\" ограничено 50 символами")
  @NotBlank(message = "Поле \"name\" должно иметь хотя бы один символ (не пробел)")
  private String name;

  @Size(max = 255, message = "Поле \"description\" ограничено 255 символами")
  private String description;
}
