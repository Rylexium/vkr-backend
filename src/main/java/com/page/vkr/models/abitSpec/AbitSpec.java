package com.page.vkr.models.abitSpec;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="abit_spec")
@Data //auto generat getters and setters
@IdClass(AbitSpecId.class)
public class AbitSpec {
    @Id
    private Long id_abit;
    @Id
    private String id_spec;
    @Id
    private Integer type_of_study;
    private Integer priority;
    private Integer id_financing;
    private String date_filing;
}
