package com.wff.ms.directory.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность описывающая класс артефакта
 *
 * @author Orlov
 * @since 01.2024
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artifact_class")
@Schema(description = "Entity Сущность описывающая класс артефакта")
public class ArtifactClass {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id класса артефакта")
  private Integer id;

  @Schema(description = "Наименование класса артефакта")
  private String name;
}
