package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abit_privileges")
@Data //auto generat getters and setters
public class AbitPrivileges {
    @Id
    private Long id_abit;
    private String privilege;
}
