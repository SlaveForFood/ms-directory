package com.wff.ms.directory.models.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Data
@Entity
public class HeroesToSkills {
    @Id
    private Integer id;
    @OneToOne
    private Heroes hero;
    // @OneToMany
    //private List <Skill> skills;
}
