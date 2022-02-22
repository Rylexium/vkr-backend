package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abit_passport")
@Data //auto generat getters and setters
public class AbitPassport {
    @Id
    private Long id_abit;
    private String passport1;
    private String passport2;
    private String snills;
}
