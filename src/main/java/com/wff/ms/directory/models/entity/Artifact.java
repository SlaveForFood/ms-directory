package com.wff.ms.directory.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность описывающая артефакт
 *
 * @author Orlov
 * @since 01.2024
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artifacts")
@Schema(description = "Entity Сущность описывающая артефакт")
public class Artifact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id артефакта")
  private Integer id;

  @Schema(description = "Наименование артефакта")
  private String name;

  @Schema(description = "Стоимость артефакта")
  private Integer cost;

  @Column(name = "sale")
  @Schema(description = "Продаваемый ли (доступный к покупке) артефакт")
  private Boolean isSalable;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "type_id")
  @Schema(description = "Тип артефакта")
  private ArtifactType type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "class_id")
  @Schema(description = "Класс артефакта")
  private ArtifactClass clazz;
}
