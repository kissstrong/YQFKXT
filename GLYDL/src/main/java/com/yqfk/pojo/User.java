package com.yqfk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private String userid;

    private String username;

    private String password;

    private String phone;

    private String roleid;

}
