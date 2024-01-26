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
@Table(name = "entities")
public class Entities {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  private String name;

  private Integer cost;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "tier_id")
  private Tier tier;
}
