package com.wff.ms.directory.models.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "HeroToSkill")
public class FactionToBaseSkill {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @OneToMany private List<Hero> hero;
}
