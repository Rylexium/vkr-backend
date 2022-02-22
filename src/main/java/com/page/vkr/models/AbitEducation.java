package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abit_education")
@Data //auto generat getters and setters
public class AbitEducation {
    @Id
    private Long id_abit;
    private String education1;
    private String education2;

    public AbitEducation(){}

    public AbitEducation(Long id,
                        String education1,
                        String education2)
    {
        this.id_abit = id;
        this.education1 = education1;
        this.education2 = education2;
    }

}
