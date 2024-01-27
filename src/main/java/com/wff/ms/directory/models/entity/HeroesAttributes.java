package com.wff.ms.directory.models.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность описывающая связь героев и атрибутов
 *
 * @author Orlov
 * @since 01.2024
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heroes_attributes")
@Schema(description = "Entity Сущность описывающая связь героев и атрибутов")
public class HeroesAttributes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Id связи артефакта и атрибута")
  private Integer id;

  @Schema(description = "Значение связанного атрибута у героя")
  private String count;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "heroes_id")
  @Schema(description = "Герой")
  private Hero hero;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "attribute_id")
  @Schema(description = "Атрибут")
  private Attribute attribute;
}
