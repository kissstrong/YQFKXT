package com.yqfk.service;

import com.yqfk.pojo.Admin;

/**
 * @author cyz
 * @date 2020-10-12 11:37
 */
public interface AdminService {
    public boolean checkLogin(String Username,String password);
    Admin queryAdminByPhone(String phone);
    void save(Admin admin);
}
