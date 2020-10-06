package com.yqfk.pojo;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@Data
public class Admin {

    @Id
    private String userid;

    private String loginname;

    private String password;

}
