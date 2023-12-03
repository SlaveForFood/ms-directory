package com.wff.ms.directory.models.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Heroes {
    @Id
    private Integer id;
    private String name;
    private String description;
    // @OneToOne
    // private IDfaction;
}
