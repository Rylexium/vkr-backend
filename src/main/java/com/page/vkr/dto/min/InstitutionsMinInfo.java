package com.page.vkr.dto.min;

import lombok.Data;

@Data
public class InstitutionsMinInfo {
    Integer id;
    String name;

    public InstitutionsMinInfo(){
    }

    public InstitutionsMinInfo(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}
