package com.page.vkr.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.page.vkr.utils.HashPass.generateSalt;
import static com.page.vkr.utils.HashPass.getHashSha256;


@Entity
@Table(name="users")
@Data //auto generat getters and setters
public class Users {
    @Id
    private String login;
    private String password;
    private String salt1;
    private String salt2;
    private Long id_abit;
    private Boolean is_entry;

    public Users(){
    }

    public Users(String login,
                String password,
                Long id_abit){
        this.login = login;
        this.salt1 = generateSalt();
        this.salt2 = generateSalt();
        this.password = getHashSha256(password, salt1, salt2);
        this.id_abit = id_abit;
        this.is_entry = false;
    }

    public Users(Users user){
        this.login = user.login;
        this.salt1 = generateSalt();
        this.salt2 = generateSalt();
        this.password = getHashSha256(user.password, salt1, salt2);
        this.id_abit = user.id_abit;
        this.is_entry = false;
    }
}
