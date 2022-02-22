package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sex")
@Data //auto generat getters and setters
public class Sex {
    @Id
    Boolean id;
    String name;
}
