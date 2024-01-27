package com.wff.ms.directory.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heroes_skills")
@Schema(description = "Entity Сущность описывающая связь героев и навыков")
public class HeroesSkills {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id связи героев и навыков")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "heroes_id")
  @Schema(description = "Герой")
  private Hero hero;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "skills_id")
  @Schema(description = "Навык")
  private Skill skill;
}
