package com.wff.ms.directory.models.entity;

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
@Table(name = "base_skills")
public class BaseSkill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String description;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_base_skill_id")
  private BaseSkill parentBaseSkill;
}
