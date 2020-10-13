package com.yqfk.service;

import com.yqfk.pojo.User;

import java.util.List;

/**
 * @author cyz
 * @date 2020-10-12 11:37
 */
public interface UserService {
     List<User> findAll();

     User queryById(int id);

     void update(User user);

     void deleteById(int id);

     void save(User user);
     User queryUserByPhone(String phone);
     boolean checkUser(String name,String password);

     void sendMsg(String mobile);
}
