package com.yqfk.dao;

import com.yqfk.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminDao extends JpaRepository<Admin, Integer>{
    Admin queryAdminByUsernameAndPassword(String Username,String Password);
    Admin queryAdminByPhone(String phone);
}
