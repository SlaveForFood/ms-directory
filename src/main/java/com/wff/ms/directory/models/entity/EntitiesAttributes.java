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
@Table(name = "entities_attributes")
public class EntitiesAttributes {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  private Integer count;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "entities_id")
  private Entiti entiti;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "attribute_id")
  private Attribute attribute;
}
