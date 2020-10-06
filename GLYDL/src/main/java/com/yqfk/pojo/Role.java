package com.yqfk.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "/role")
@Data
public class Role {

    @Id
    private String roleid;
    private String rolename;


}
