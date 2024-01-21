package com.wff.ms.directory.models.dto;

import com.wff.ms.directory.models.entity.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {

  public SkillDto(Skill skill) {
    id = skill.getId();
    name = skill.getName();
    description = skill.getDescription();
  }

  private Integer id;

  private String name;

  private String description;
}
