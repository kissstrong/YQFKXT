package com.yqfk.pojo;
import lombok.Data;
import java.io.Serializable;
@Data
public class Admin implements Serializable {
    private int userid;
    private String username;
    private String password;
    private String phone;
}
