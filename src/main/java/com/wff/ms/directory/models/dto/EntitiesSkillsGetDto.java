package com.wff.ms.directory.models.dto;

import com.wff.ms.directory.models.entity.Skill;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntitiesSkillsGetDto {

  private List<Skill> skills;
}
