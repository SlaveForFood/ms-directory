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
@Table(name = "skills")
@Schema(description = "Сущность описывающая умение")
public class Skill {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  @Schema(description = "Id умения")
  private Integer id;

  @Schema(description = "Наименование умения")
  private String name;

  @Schema(description = "Описание умения")
  private String description;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_skill_id")
  @Schema(description = "Родительское умение")
  private Skill parentSkill;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "base_skill_id")
  @Schema(description = "Базовое умение")
  private BaseSkill baseSkill;
}
