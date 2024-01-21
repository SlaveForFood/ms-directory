package com.wff.ms.directory.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность описывающая связь героев и артефактов
 *
 * @author Orlov
 * @since 01.2024
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heroes_artifacts")
@Schema(description = "Entity Сущность описывающая связь героев и артефактов")
public class HeroesArtifacts {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id связи героев и артефактов")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "heroes_id")
  @Schema(description = "Герой")
  private Hero hero;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "artefacts_id")
  @Schema(description = "Артефакт")
  private Artifact artifact;
}
