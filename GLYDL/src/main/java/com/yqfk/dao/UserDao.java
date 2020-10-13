package com.yqfk.dao;

import com.yqfk.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDao extends JpaRepository<User, Integer>{
   User queryUserByUsernameAndPassword(String Username,String Password);
   User queryUserByPhone(String phone);
}
