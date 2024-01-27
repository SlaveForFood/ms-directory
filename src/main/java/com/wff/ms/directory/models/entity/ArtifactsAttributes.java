package com.wff.ms.directory.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Сущность описывающая связь артефактов и атрибутов
 *
 * @author Orlov
 * @since 01.2024
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "artifacts_attributes")
@Schema(description = "Entity Сущность описывающая связь артефактов и атрибутов")
public class ArtifactsAttributes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id связи артефакта и атрибута")
  private Integer id;

  @Schema(description = "Значение связанного атрибута у артефакта")
  private Integer count;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "artifact_id")
  @Schema(description = "Артефакт")
  private Artifact artifact;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "attribute_id")
  @Schema(description = "Атрибут")
  private Attribute attribute;
}
