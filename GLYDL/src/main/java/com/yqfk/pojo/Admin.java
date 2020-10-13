package com.yqfk.pojo;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
@Data
public class Admin implements Serializable {

    @Id
    @GeneratedValue
    private int userid;
    private String username;
    private String password;
    private String phone;
}
