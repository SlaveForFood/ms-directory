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
@Table(name = "entities_skills")
public class EntitiesSkills {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "entities_id")
  @Schema(description = "Существо")
  private Entiti entiti;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "skills_id")
  @Schema(description = "Умение")
  private Skill skill;
}
