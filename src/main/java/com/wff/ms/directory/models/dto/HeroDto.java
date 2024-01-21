package com.wff.ms.directory.models.dto;

import com.wff.ms.directory.models.entity.Hero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {
    
    private Integer id;

    private String name;

    private String description;

    // @OneToOne
    // private IDfaction;

}
