package com.yqfk.service.impl;
import com.yqfk.dao.AdminDao;
import com.yqfk.pojo.Admin;
import com.yqfk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AdminDao adminDao;

    public boolean checkLogin(String Username,String password){
        Admin admin = adminDao.queryAdminByUsernameAndPassword(Username, password);
        if (admin!=null){
            redisTemplate.opsForHash().put("admin",admin.getUserid(),admin);
            return true;
        }
        return false;
    }

    @Override
    public Admin queryAdminByPhone(String phone) {
        return adminDao.queryAdminByPhone(phone);
    }

    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }


}
