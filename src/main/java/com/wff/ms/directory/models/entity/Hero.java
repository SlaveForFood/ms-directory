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
@Table(name = "heroes")
@Schema(description = "Entity Сущность описывающая героя")
public class Hero {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id героя")
  private Integer id;

  @Schema(description = "Наименование героя")
  private String name;

  @Schema(description = "Описание героя")
  private String description;

  @ManyToOne
  @JoinColumn(name = "faction_id")
  @Schema(description = "Фракция героя")
  private Faction faction;
}
